package com.wpx.jvm.demo03;

import java.util.Vector;
/**
 * ���쳣
 * 
 * @author wangpx
 */
public class HeapDumpOnOutOfMemoryError {

	public static void main(String[] args) {
		
		//-Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:/HeapDumpOnOutOfMemoryError.dump
		//���ڴ���� ʹ��mat ( memory analyzer ) ��.dump�ļ� 
		Vector v = new Vector();
		for(int i=0; i < 5; i ++){
			v.add(new Byte[1*1024*1024]);
		}
		
	}

	
}
