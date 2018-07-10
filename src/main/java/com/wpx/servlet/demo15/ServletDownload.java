package com.wpx.servlet.demo15;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �ļ�����
 * 
 * @author wangpx
 */
public class ServletDownload extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ�����·��
		String realPath = getServletContext().getRealPath("/images/rBAAC1oRL7aAHOTuAAEbdZSKUX0630.png");
		//��ȡ�ļ�����
		String filename=null;
		//��ȡ���һ��\��λ��
		int indexOf = realPath.lastIndexOf("\\");
		if(indexOf!=-1) {
			filename = realPath.substring(indexOf+1);
		}
		//��ȡ�û�����
		String agent = req.getHeader("User-Agent");
		if(agent.contains("MSIE")){
			filename = URLEncoder.encode(filename,"UTF-8");
		}
		if(filename != null) {
			//����ͷ��Ϣ
			resp.setHeader("Content-Disposition", "attachment;filename"+filename);
			FileInputStream in = new FileInputStream(realPath);
			//ͨ��response ��ȡ�����
			OutputStream outputStream = resp.getOutputStream();
			byte[] buf =new byte[1024];
			int length=0;
			while((length=in.read(buf))!=-1) {
				outputStream.write(buf, 0, length);
			}
			in.close();
			outputStream.close();
		}
	}
	

	
}
