package com.wpx.netty.demo02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * �������˴�����
 * 
 * @author wangpx
 */
public class ServerHandler  implements Runnable{
	private Socket socket;
	public ServerHandler(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		BufferedReader in =null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(),true);
			String body =null;
			while(true) {
				body = in.readLine();
				if( body == null) {
					break;
				}
				System.out.println("�ͻ��˷��͵�����Ϊ" + body);
				out.println("����˵���Ӧ����....");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(in != null){
				try {
					in.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
	}

}
