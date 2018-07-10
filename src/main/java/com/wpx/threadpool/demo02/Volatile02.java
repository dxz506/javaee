package com.wpx.threadpool.demo02;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * volatile�ؼ��ֿ��Ա�֤�߳̿ɼ�,���ǲ�������ͬ����
 * 
 * 
 * @author wangpx
 */
public class Volatile02 extends Thread {

	//private static AtomicInteger count = new AtomicInteger(0); 
	private static int count;
	
	private static void addCount() {
		for(int i = 0;i < 1000;i++) {
			//count.incrementAndGet();
			count++;
		}
		System.out.println(count);
	}
	
	@Override
	public void run() {
		addCount();
	}
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			new Volatile02().start();
		}
	}	
}
