package com.fanavard.challenge.server.socket;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
import io.netty.buffer.ByteBuf;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Handles a server-side channel.
 */
@Component
public class SocketServerHandler extends ChannelHandlerAdapter { // (1)
    private static Logger logger = LoggerFactory.getLogger(SocketServer.class);

    @Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
        logger.debug("write time");
        final ByteBuf time = ctx.alloc().buffer(4); // (2)
        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

        final ChannelFuture f = ctx.writeAndFlush(time); // (3)
        f.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture future) {
                assert f == future;
                ctx.close();
            }
        }); // (4)
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }}
