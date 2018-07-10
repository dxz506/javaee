package com.wpx.netty.demo07.googleprotobuf;

import com.wpx.netty.demo07.googleprotobuf.SubscribeReqProto.SubscribeReq;


import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
/**
 * netty 5
 * 
 * @author wangpx
 */
@Sharable
public class ServerHandler extends ChannelHandlerAdapter{

@Override
public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
	//��msgת��Ϊָ����ʽ
	SubscribeReqProto.SubscribeReq req=(SubscribeReq) msg;
	System.out.println(" ����˽��ܵ�����Ϣ:  "+req.toString());
	ctx.writeAndFlush(resp(req.getSubReqID()));
}
	private SubscribeRespProto.SubscribeReq resp(int subReqID){
		SubscribeRespProto.SubscribeReq.Builder builder = SubscribeRespProto.SubscribeReq.newBuilder();
		builder.setSubReqID(subReqID);
		builder.setRespCode(0);
		builder.setDesc("desc message ...");
		return builder.build();
	}
	@Override
		public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
			cause.printStackTrace();
			ctx.close();
		}
}
