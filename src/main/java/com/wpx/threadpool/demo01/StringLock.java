package com.wpx.threadpool.demo01;
/**
 * ������Ҫ��String������Ϊ��,�������ѭ��������
 * 
 * 
 * @author wangpx
 */
public class StringLock {

	public void method01() {
		/**
		 * ��new String("�ַ�������") ֱ���滻Ϊһ���ַ�����������
		 */
		synchronized (new String("�ַ�������")) {
			try {
				while(true) {
					System.out.println(Thread.currentThread().getName()+" start ...");
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName()+" end ...");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		final StringLock sl = new StringLock();
		new Thread( () -> { sl.method01(); },"t1") .start();
		new Thread( () -> { sl.method01(); },"t2") .start();
	}
}
