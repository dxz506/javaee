package com.wpx.threadpool.demo08;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * �Զ����̳߳�
 * 
 * @author wangpx
 */
public class CustomTest implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() +" is running ....");
	}

	public static void main(String[] args) {
	
		ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue(10);
	
		ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 20, 120L, TimeUnit.SECONDS, queue);
		
		for(int i=0;i<20;i++) {
			pool.execute(new CustomTest());
		}
	}
}
