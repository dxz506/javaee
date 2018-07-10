package com.wpx.netty.demo07.jbossmarshalling;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * ����˴�����
 * @author wangpx
 */
public class ServerHandler extends ChannelHandlerAdapter{

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		System.out.println("  Channel read method invoke ....");
		Person p = (Person) msg;
		System.out.println("�ͻ��˷�������Ϊ: id "+p.getId()+" name "+p.getName()+"  Age "+p.getAge());
		
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
