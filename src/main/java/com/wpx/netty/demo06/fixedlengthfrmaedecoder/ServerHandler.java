package com.wpx.netty.demo06.fixedlengthfrmaedecoder;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * ����˴�����
 * @author wangpx
 */
@SuppressWarnings("all")
public class ServerHandler  extends ChannelHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String data=(String) msg;
		System.out.println("�ͻ��˷��͵�����Ϊ "+msg);
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
