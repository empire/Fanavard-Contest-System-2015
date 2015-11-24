package com.fanavard.challenge.server.socket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by ocean on 11/24/15.
 */
public class SimpleObjectDecoder extends ReplayingDecoder<Void> {
    private static Logger logger = LoggerFactory.getLogger(SimpleObjectDecoder.class);

    @Override
    protected void decode(
            ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        logger.debug("Waiting for bytes");

        out.add(in.readBytes(4));
        logger.debug("Bytes are received!");
    }
}
