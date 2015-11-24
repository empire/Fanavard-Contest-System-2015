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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Scanner;

@Component
public class SocketClientHandler extends ChannelHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(SocketClientHandler.class);

    @Autowired
    CliApplication cliApplication;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        cliApplication.dataReceived(ctx.channel(), msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}

