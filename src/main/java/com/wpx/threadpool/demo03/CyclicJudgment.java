package com.wpx.threadpool.demo03;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ԭʼ�ķ���ͨ�����ϵ�ѭ�����ж�
 * 
 * wait/notifyҪ��synchronized�ؼ���һ��ʹ��
 *
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class CyclicJudgment {

	private volatile static List list = new ArrayList<>();  

	public void add() {
		list.add("wangpx");
	}
	public int size() {
		return list.size();
	}
	public static void main(String[] args) {
		final CyclicJudgment cj = new CyclicJudgment();
		final Object lock = new Object();
		Thread t1 = new Thread( () -> {
			try {
				synchronized (lock) {
					for(int i = 0;i < 10;i++) {
						cj.add();
						System.out.println(Thread.currentThread().getName()+"�����һ��Ԫ��...");
						Thread.sleep(3000);
						//�����ϴ�С����5ʱȥ����֪ͨ
						if(cj.size() == 5) {
							lock.notify();
							System.out.println("����֪ͨ,������һ���߳�....");
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}) ;
		
		Thread t2 = new Thread( () ->  {
			synchronized (lock) {
				if(cj.size() != 5) {
					try {
						lock.wait();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() +"��ǰ�߳��յ�֪ͨ...");
				int i = 1/0;
			}
		});
		
		t2.start();
		t1.start();
		
		/**
		 *  Thread-0�����һ��Ԫ��...
			Thread-0�����һ��Ԫ��...
			Thread-0�����һ��Ԫ��...
			Thread-0�����һ��Ԫ��...
			Thread-0�����һ��Ԫ��...
			����֪ͨ,������һ���߳�....
			Thread-0�����һ��Ԫ��...
			Thread-0�����һ��Ԫ��...
			Thread-0�����һ��Ԫ��...
			Thread-0�����һ��Ԫ��...
			Thread-0�����һ��Ԫ��...
			Thread-1��ǰ�߳��յ�֪ͨ...
			Exception in thread "Thread-1" java.lang.ArithmeticException: / by zero
				at com.wpx.threadpool.demo03.CyclicJudgment.lambda$1(CyclicJudgment.java:57)
				at java.lang.Thread.run(Thread.java:748)
			
			ִ�н������,������Ϊwait���ͷ���,��notify�����ͷ���,�߳�2������,ִ�е�wait���ͷ���,�߳�1��ʼ����ִ��,��size()==5ʱ,
			���̷߳���֪ͨ��,�߳�2��Ȼ�ӵ�֪ͨ,���޷���ȡ��lock��,�ʵ��߳�1ִ�к�������ʼִ���߳�2������

		 */
	}
}
