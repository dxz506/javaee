package com.wpx.netty.demo03;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * �������
 * 
 * @author wangpx
 */
public class Server implements Runnable{

	//��·������(�������е�ͨ��)
	private Selector selector;
	//����������
	private ByteBuffer readBuf = ByteBuffer.allocate(1024);
	private ByteBuffer writeBuf = ByteBuffer.allocate(1024);
	
	public Server(int port) {
		try {
			//1. �򿪶�·������
			this.selector = Selector.open();
			//2. �򿪷�����ͨ��
			ServerSocketChannel ssc = ServerSocketChannel.open();
			//3. ���÷�����ͨ��Ϊ������ģʽ
			ssc.configureBlocking(false);
			//4. �󶨵�ַ
			ssc.bind(new InetSocketAddress(port));
			//5. ��������ͨ��ע�ᵽ��·��������,�����������¼�
			ssc.register(this.selector, SelectionKey.OP_ACCEPT);
			System.out.println("Server start , Port :"+port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		while(true) {
			try {
				//�ö�·��������ʼ����
				this.selector.select();
				//�������е�Selector��key���ص�����
				Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
				//���б���
				while(keys.hasNext()) {
					//��ȡһ��ѡ���Ԫ��
					SelectionKey key = keys.next();
					//���������Ƴ�
					keys.remove();
					//�������Ч�� �Բ�ͬ��������в�ͬ�Ĵ���
					if(key.isValid()) {
						//�����������
						if(key.isAcceptable()) {
							this.accept(key);
						}
						//����ǿɶ�״̬
						if(key.isReadable()) {
							this.read(key);
						}
						//���Ϊ��д
						if(key.isWritable()) {
							this.write(key);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	private void write(SelectionKey key) {
	
		
	}

	private void read(SelectionKey key) {
		try {
			//��ջ�����������
			this.readBuf.clear();
			//��ȡ֮ǰע���Socket����
			SocketChannel sc=(SocketChannel) key.channel();
			//��ȡ����
			int count = sc.read(this.readBuf);
			if(count == -1) {
				key.channel().close();
				key.cancel();
				return;
			}
			//���������ȡ,��ȡ֮ǰ��Ҫ���и�λ����
			this.readBuf.flip();
			//���ݻ����������ݳ��ȴ�����Ӧ��Сbyte����,���ܻ�����������
			byte[] bytes = new byte[this.readBuf.remaining()];
			this.readBuf.get(bytes);
			//��ӡ���
			String body=new String(bytes).trim();
			System.out.println("�ͻ��˷��͵�����Ϊ   "+body);
		} catch (Exception e) {
			
		}
		
	}

	private void accept(SelectionKey key) {
		try {
			//��ȡ����ͨ��
			ServerSocketChannel ssc=(ServerSocketChannel) key.channel();
			//ִ����������
			SocketChannel sc = ssc.accept();
			//��������ģʽ
			sc.configureBlocking(false);
			//ע�ᵽ��·��������,�����ö�ȡ��ʶ
			sc.register(this.selector,SelectionKey.OP_READ);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new  Thread(new Server(8888)).start();;
	}

}
