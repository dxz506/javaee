package com.wpx.threadpool.demo01;
/**
 * 
 * ͬ��:synchronized
 *  ͬ���ĸ�����ǹ��� ���ڹ������Դ   ��֤�̵߳�ԭ���Ժͻ��ɼ���
 *  �첽:asynchronized
 *  �첽�ĸ���Ϊ����,�໥֮�䲻�ܵ��κε���Լ
 * @author wangpx
 */
public class SyncInvocation {

	public synchronized  void method01() {
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/** ����synchronized  t1,t2��ͬʱ��ӡ,t1�߳��ȳ���d�Ķ�����,t2�߳̿������첽�ķ�ʽȥ���ö�����û����synchronized���εķ���
	 * ��synchronized   t1, �ȴ�4�� t2 t1�Ȼ��d�Ķ�����,t2�߳���Ҫ�ȴ���,Ҳ���ǻ�ͬ��
	 **/
	public synchronized void method02() {
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		final SyncInvocation si=new SyncInvocation();
		Thread t1 = new Thread( () -> { si.method01(); } ,"t1") ;
		Thread t2 = new Thread( () -> { si.method02(); } ,"t2") ;
		t1.start();
		t2.start();
	}
}
