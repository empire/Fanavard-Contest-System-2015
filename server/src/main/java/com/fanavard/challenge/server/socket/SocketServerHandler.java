package com.fanavard.challenge.server.socket;

/**
 * Created by ITRENT2 on 11/23/2015.
 */
import com.fanavard.challenge.core.model.Command;
import com.fanavard.challenge.server.command.CommandExecutor;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Handles a server-side channel.
 */
@Component
public class SocketServerHandler extends ChannelHandlerAdapter { // (1)
    private static Logger logger = LoggerFactory.getLogger(SocketServer.class);

    @Autowired
    CommandExecutor commandExecutor;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.debug("channelActive");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (!(msg instanceof Command)) {
            logger.warn("Invalid data is received (instance of Command wanted) {}", msg.getClass());
            return;
        }

        Object result = commandExecutor.execute((Command) msg);
        logger.debug("Get result {}", result);
        ctx.writeAndFlush(result);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
