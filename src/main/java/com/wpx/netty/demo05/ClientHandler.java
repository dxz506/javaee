package com.wpx.netty.demo05;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
/**
 * �ͻ��˴�����
 * 
 * @author wangpx
 */
public class ClientHandler extends ChannelHandlerAdapter{
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf=(ByteBuf) msg;
		byte[] data=new byte[buf.readableBytes()];
		buf.readBytes(data);
		String response = new String(data,"utf-8");
		System.out.println("�ͻ�����Ӧ����Ϊ: "+response);
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
