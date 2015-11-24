package com.fanavard.challenge.client.socket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by ocean on 11/24/15.
 */
public class SimpleObjectEncoder extends MessageToByteEncoder<Integer> {
    private static final Logger logger = LoggerFactory.getLogger(SimpleObjectEncoder.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, Integer msg, ByteBuf out) {
        logger.debug("Encoding {}", msg);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject("Sample string for serializing");
            oos.writeInt(msg);
            oos.close();
        } catch (IOException e) {
            logger.error("Error serializing objects", e);
        }

        out.writeBytes(baos.toByteArray());
    }
}
