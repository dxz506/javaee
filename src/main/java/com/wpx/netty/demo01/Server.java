package com.wpx.netty.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class Server {

	public static void main(String[] args) {
		//�½�serverSocket�������8888�˿�
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(8888);
			//serverSocket��accept�����Ὣ������
			Socket socket = serverSocket.accept();
			//������һ���߳�ȥ����
			new Thread(new ServerHandler(socket)).start();
			}
		catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
