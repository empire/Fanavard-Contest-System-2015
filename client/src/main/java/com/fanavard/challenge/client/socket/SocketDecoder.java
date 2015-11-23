package com.fanavard.challenge.client.socket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by ocean on 11/23/15.
 */
public class SocketDecoder extends ReplayingDecoder<Void> {
    private static final Logger logger = LoggerFactory.getLogger(SocketDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx,
                          ByteBuf in, List<Object> out) {
        logger.debug("Adding to output");
        out.add(in.readBytes(4));
        logger.debug("Added");
    }
}

