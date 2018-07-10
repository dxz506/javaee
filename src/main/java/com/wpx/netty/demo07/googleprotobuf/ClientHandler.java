package com.wpx.netty.demo07.googleprotobuf;

import java.util.ArrayList;



import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 
 * �ͻ��˴�����
 * @author wangpx
 */
public class ClientHandler extends ChannelHandlerAdapter{

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		for(int i=0;i<10;i++) {
			ctx.write(subReq(i));
		}
		ctx.flush();
	}
	
	private SubscribeReqProto.SubscribeReq subReq(int i){
		SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
		builder.setSubReqID(i);
		builder.setUserName("wangpx"+i);
		builder.setProductName("ProductName"+i);
		ArrayList<String> address = new ArrayList<String>();
		address.add("Henan anyang");
		address.add("Guangdong zhaoqing");
		builder.addAllAddress(address);
		return builder.build();
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("����˵���Ӧ: "+msg);
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
