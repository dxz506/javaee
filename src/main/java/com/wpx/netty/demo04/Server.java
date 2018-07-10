package com.wpx.netty.demo04;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ��������
 * 
 * @author wangpx
 */
public class Server {
	//�̳߳�
		private ExecutorService executorService;
		//�߳���
		private AsynchronousChannelGroup threadGroup;
		//������ͨ��
		public AsynchronousServerSocketChannel assc;
		
		public Server(int port) {
			try {
				//����һ���̳߳�
				executorService = Executors.newCachedThreadPool();
				//�����߳���
				threadGroup=  AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
				//����������ͨ��
				assc=AsynchronousServerSocketChannel.open(threadGroup);
				//���а�
				assc.bind(new InetSocketAddress(port));
				System.out.println("Server start , port "+port);
				//��������
				assc.accept(this,new ServerHandler());
				//һֱ����
				Thread.sleep(Integer.MAX_VALUE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static void main(String[] args) {
			 new Server(8888);
		}
}
