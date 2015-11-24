package com.fanavard.challenge.client.socket;

/**
 * Created by ocean on 11/23/15.
 */
import com.fanavard.challenge.client.cli.CliApplication;
import com.fanavard.challenge.core.model.UnixTime;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.buffer.WrappedByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Scanner;

@Component
public class SocketClientHandler extends ChannelHandlerAdapter {
//    private ByteBuf buf;

    @Autowired
    CliApplication cliApplication;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
//        buf = ctx.alloc().buffer(4); // (1)

      }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
//        buf.release(); // (1)
//        buf = null;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        cliApplication.run();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf m = (ByteBuf) msg;
//        System.out.println(m.toString(CharsetUtil.UTF_8));
//
        ctx.write(msg);

//        ByteBuf buffer = Unpooled.copiedBuffer("[3]", CharsetUtil.UTF_8);
//        ctx.writeAndFlush(buffer);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}

