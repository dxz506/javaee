package com.wpx.netty.demo05;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * 
 * ����˴�����
 * 
 * @author wangpx
 */
public class ServerHandler extends ChannelHandlerAdapter{

	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
			ByteBuf buf=(ByteBuf) msg;
			byte[] data= new byte[buf.readableBytes()];
			buf.readBytes(data);
			String request = new String(data,"utf-8");
			System.out.println("Client: "+request);
			ctx.channel().writeAndFlush(Unpooled.copiedBuffer("Hello ".getBytes()));
			
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	
}
