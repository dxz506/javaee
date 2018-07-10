package com.wpx.threadpool.demo01;



/**
 * 
 * ���и��Ӽ̳й�ϵ�ķ�����
 *  			����synchronizedҲ���̰߳�ȫ�� 
 *
 * @author wangpx
 */
public class Extends {

	static class Sup{
		public static int i = 10;
		
		public synchronized void operationSup() {
			try {
				i--;
				System.out.println("Sup print i = "+i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	static class Sub extends Sup{

		public synchronized void operationSub() {
			try {
			while(i > 0) {
				i--;
				System.out.println("Sub print i = "+i);
				Thread.sleep(100);
				this.operationSup();
				} 
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Thread t1=new Thread( ()-> {
			Sub s=new Sub();
			s.operationSub();
		} );
		t1.start();
	}
	
}
