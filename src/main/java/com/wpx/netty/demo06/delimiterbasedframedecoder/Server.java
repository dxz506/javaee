package com.wpx.netty.demo06.delimiterbasedframedecoder;



import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 
 * DelimiterBasedFrameDecoder
 * ͨ���Զ���ָ����ķ�ʽ��ʵ�����ݵĽ�ȡ
 * 
 * @author wangpx
 */
public class Server {


	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
	
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap serverBootstrap = new  ServerBootstrap();
			serverBootstrap.group(bossGroup, workGroup)
						   .channel(NioServerSocketChannel.class)
		/**
		 * �ڷ�����TCP�ں�ģ��ά������������
		 * �ͻ���������connect��ʱ��,�ᷢ�ʹ���SYN��־�İ�(��һ������)
		 * ������յ��ͻ��˷�����SYNʱ,��ͻ��˷���SYN ACKȷ��(�ڶ�������) ��ʱTcp��ѿͻ������Ӽ��뵽����1��
		 * ��������յ��ͻ��˷���ACKʱ(����������) Tcp�ں˻�ѿͻ��˴Ӷ���1�зŵ�����2�� ,�������,Ӧ�ó���accept����
		 * 
		 * SO_BACKLOG ΪΪ�������еĳ���,���������еĳ��ȴ���backlogʱ,�����ӻᱻTCP�ں˾ܾ�
		 * backlog�Գ���֧�ֵ����Ӳ���Ӱ��,backlogӰ���ֻ��û�б�acceptȡ��������
		 * 
		 */
						   .option(ChannelOption.SO_BACKLOG, 1024)
						   .childHandler(new ChannelInitializer<SocketChannel>() {
							@Override
							protected void initChannel(SocketChannel ch) throws Exception {
								ByteBuf delimiter=Unpooled.copiedBuffer("$$_".getBytes());
								ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,delimiter));
								ch.pipeline().addLast(new StringDecoder());
								ch.pipeline().addLast(new ServerHandler());
							}
						});
			ChannelFuture future = serverBootstrap.bind(8888).sync();
			future.channel().closeFuture().sync();
			
						   
		} finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
		
	}
}
