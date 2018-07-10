package com.wpx.netty.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 
 * �½��߳�
 * ����һ�������̳߳�
 * 
 * 
 * @author wangpx
 */
class Task extends Thread{
	@Override
	public void run() {
		System.out.println("���񷽷�ִ��...");
	}
}
public class TestTimeJob {

	public static void main(String[] args) {
		Task task = new Task();
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		/**
		 *  4������
		 *  task:һ������,��Ҫ��Ϊһ���߳�
		 *  1:��һ��ִ��ʱ��
		 *  2:û������ִ��һ��
		 *  TimeUnit.SECONDS: ʱ�������λ
		 */
		scheduler.scheduleWithFixedDelay(task, 1, 3, TimeUnit.SECONDS);
	}
}
