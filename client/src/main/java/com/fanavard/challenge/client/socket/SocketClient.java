package com.fanavard.challenge.client.socket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ObjectEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by ocean on 11/23/15.
 */
@Component
public class SocketClient {
    private final String host = "127.0.0.1";
    private final int port = 8080;
    private Bootstrap b;
    private NioEventLoopGroup workerGroup;

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

        // Wait until the connection is closed.
        f.channel().closeFuture().sync();
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
