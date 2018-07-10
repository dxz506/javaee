package com.wpx.netty.demo07.messagepack;

import org.msgpack.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * MessagePack ������
 * 
 * @author wangpx
 */
public class MsgpackEncoder extends MessageToByteEncoder<Object> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
		MessagePack messagePack = new MessagePack();
		//���л�
		byte[] data = messagePack.write(msg);
		out.writeBytes(data);
	}

}
