package com.wpx.threadpool.demo01;
/**
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class ThreadLock {

	private static int number =0;
	
	/**
	 *  
	 *  
	 	����static��������ͬʱ��ӡ,Ҳ����ζ�������߳�ͬʱ���뷽����
	 	�����������������,ÿ������һ����
	 	
	 	��static���κ�,ֻ��һ���߳̽����˷�����,
	 	����̬�����ϵ���Ϊ�༶�����,����ʵ���������ٶ�ֻ��һ����

	 */
	public static synchronized void printNum(String num) {
		try {
			if(num.equals("a")) {
				number=100;
				System.out.println("num a,set num over!");
				Thread.sleep(2000);
			}else {
				number=200;
				System.out.println("num b,set num over!");
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			new RuntimeException("�����쳣");
		}
	}
	
	public static void main(String[] args) {
		
		final ThreadLock tl01 = new ThreadLock();
		final ThreadLock tl02 = new ThreadLock();
		Thread t1 =new Thread( () -> { tl01.printNum("a"); });
		Thread t2=new Thread( () -> { tl02.printNum("b"); });
		
		t1.start();
		t2.start();
		
		
		
	}
}
