package com.fanavard.challenge.client.socket;

import com.fanavard.challenge.client.cli.CliApplication;
import com.fanavard.challenge.core.config.ServerConfig;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by ocean on 11/23/15.
 */
@Component
public class SocketClient {
    private final String host = ServerConfig.HOST_NAME;
    private final int port = ServerConfig.PORT_NUMBER;

    private Bootstrap b;
    private NioEventLoopGroup workerGroup;

    @Autowired
    CliApplication cliApplication;

    @Autowired
    ApplicationContext context;

    public void run() throws Exception {
        initialize();

        try {
            configureAndStartServer();
        } finally {
            shutdownClient(workerGroup);
        }
    }

    private void configureAndStartServer() throws InterruptedException {
        configureServer();
        startServer();
    }

    private void startServer() throws InterruptedException {
        // Start the client.
        ChannelFuture f = b.connect(host, port).sync(); // (5)

        Channel channel = f.channel();
        cliApplication.run(channel);

        // Wait until the connection is closed.
        channel.closeFuture().sync();
    }

    private void configureServer() {
        b.group(workerGroup); // (2)
        b.channel(NioSocketChannel.class); // (3)
        b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
        b.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(
                        new ObjectEncoder(),
                        new ObjectDecoder(ClassResolvers.weakCachingConcurrentResolver(null)),
                        context.getBean(SocketClientHandler.class)
                        );
            }
        });
    }

    private void initialize() {
        workerGroup = new NioEventLoopGroup();
        b = new Bootstrap(); // (1)
    }

    private void shutdownClient(EventLoopGroup workerGroup) {
        workerGroup.shutdownGracefully();
    }
}
