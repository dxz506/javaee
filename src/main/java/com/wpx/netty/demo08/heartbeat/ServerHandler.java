package com.wpx.netty.demo08.heartbeat;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class ServerHandler extends ChannelHandlerAdapter{

	private int loss_connect_time=0;
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if(evt instanceof IdleStateEvent) {
			IdleStateEvent event=(IdleStateEvent)evt;
			if(event.state() == IdleState.READER_IDLE) {
				loss_connect_time++;
				System.out.println(" 10 ��û���յ��ͻ��˵���Ϣ�� ");
				if(loss_connect_time > 2 ) {
					ctx.channel().close();
				}
			}
		}else {
			super.userEventTriggered(ctx, evt);
		}
	}
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("server channelRead ...");
		System.out.println(ctx.channel().remoteAddress() +" _-> Server: "+msg.toString() );
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
