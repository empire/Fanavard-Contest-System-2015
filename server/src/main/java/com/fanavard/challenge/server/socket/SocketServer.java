package com.fanavard.challenge.server.socket;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
import io.netty.bootstrap.ServerBootstrap;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SocketServer {

    private final int port = 8080;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private ServerBootstrap serverBootstrap;

//    @Autowired
//    SocketServerHandler socketServerHandler;
//
    public void run() throws Exception {
        initialize();
        try {
            startServer();
        } finally {
            shutdown();
        }
    }

    private void startServer() throws InterruptedException {
        configureServerBootstrap();
        bind();
    }

    private void configureServerBootstrap() {
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class) // (3)
                .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new SocketServerHandler());
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)
    }

    private void bind() throws InterruptedException {
        // Bind and start to accept incoming connections.
        ChannelFuture f = serverBootstrap.bind(port).sync(); // (7)

        // Wait until the server socket is closed.
        // In this example, this does not happen, but you can do that to gracefully
        // shut down your server.
        f.channel().closeFuture().sync();
    }

    private void initialize() {
        bossGroup = new NioEventLoopGroup(); // (1)
        workerGroup = new NioEventLoopGroup();
        serverBootstrap = new ServerBootstrap();
    }

    private void shutdown() {
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }
}