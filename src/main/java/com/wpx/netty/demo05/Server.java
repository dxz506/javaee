package com.wpx.netty.demo05;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * �������
 * @author wangpx
 */
public class Server {

	public static void main(String[] args) throws InterruptedException {
		//���ڽ���Client������
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		//ʵ�ʵ�ҵ�������
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
	
		//����Bootstrap������,��Server����һϵ�е�����
		ServerBootstrap b = new ServerBootstrap();
		//�����������߳������
		b.group(bossGroup, workGroup)
		//ָ��ʹ��NioServerSocketChannel�������͵�ͨ��
		 .channel(NioServerSocketChannel.class)
		 //ʹ��childHandlerȥ�󶨾�����¼�������
		 .childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel sc) throws Exception {
				sc.pipeline().addLast(new ServerHandler());
			}
		});
		
		ChannelFuture f = b.bind(8888).sync();
		
		f.channel().closeFuture().sync();
		
		bossGroup.shutdownGracefully();
		workGroup.shutdownGracefully();
	}
}
