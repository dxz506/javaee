package com.wpx.netty.demo02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * �ͻ���
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class Client {

	
	public static void main(String[] args) {
		BufferedReader in=null;
		PrintWriter out =null;
		try {
			Socket socket=new Socket("127.0.0.1", 8756);
			in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			out.println("Hello BIO");
			String response = in.readLine();
			System.out.println("����˵���Ӧ����Ϊ: "+response);
		}catch (Exception e) {
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
