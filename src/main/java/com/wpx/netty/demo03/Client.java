package com.wpx.netty.demo03;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * �ͻ�����
 * 
 * @author wangpx
 */
public class Client {

	public static void main(String[] args) {
	
		//�������ӵ�ַ
		InetSocketAddress address = new InetSocketAddress("127.0.0.1",8888);
		//��������ͨ��
		SocketChannel sc =null;
		//����������
		ByteBuffer buf = ByteBuffer.allocate(1024);
		try {
			//��ͨ��
			sc = SocketChannel.open();
			//��������
			sc.connect(address);
			
			while(true) {
				//�Զ���һ���ֽ�����,ʹ��ϵͳ�ı�׼������
				byte[] bytes = new byte[1024];
				System.in.read(bytes);
				//�����ݷŵ�������
				buf.put(bytes);
				//�Ի��������и�λ
				buf.flip();
				//д������
				sc.write(buf);
				//��ջ���������
				buf.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
}
