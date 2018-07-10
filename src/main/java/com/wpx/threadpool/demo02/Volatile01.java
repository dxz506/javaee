package com.wpx.threadpool.demo02;
/**
 * volatile�ؼ���ʹ�����ڶ��߳�֮��ɼ�
 * 
 * @author wangpx
 */
public class Volatile01 extends Thread {

	/**
	 * ������volatile,���н��:
	 
	         ����״̬����Ϊ��false
      false
	��Ϊ isRunning������Ȼ�Ѿ��޸�Ϊfalse,���߳������еı�����û�з����ı�,��Ϊ�̼߳�����ز��ɼ���
	
	
		ͨ��volatile���λ�ʹ�߳��໥�ɼ�
	 */
	private volatile boolean isRunning = true;


	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	@Override
	public void run() {
		while(isRunning == true) {
			
		}
		System.out.println("�߳�ִ�����....");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Volatile01 v = new Volatile01();
		v.start();
		Thread.sleep(2000);
		v.setRunning(false);
		
		System.out.println("����״̬����Ϊ��false");
		Thread.sleep(3000);
		System.out.println(v.isRunning);
	}
	
}
