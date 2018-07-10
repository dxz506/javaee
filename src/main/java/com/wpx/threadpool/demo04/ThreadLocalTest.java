package com.wpx.threadpool.demo04;

/**
 * 
 * �ֲ߳̾�����,��һ�ֶ��̲߳������ʱ����Ľ������,��synchronized�����ķ�ʽ��ͬ
 * ThreadLocal����ȫ���ṩ����,��ʹ�ÿռ任ʱ��ķ�ʽ,Ϊÿһ���߳��ṩ�����Ķ����ű�,�Ա�֤�̵߳İ�ȫ
 * ������������,ThreadLocal�����о��Ե�����,�ڲ������Ǻܸߵ�ʱ��,���������ܻ����
 * ThreadLocal������һ���̶��ϼ�С������
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class ThreadLocalTest {

	private static ThreadLocal<String> th = new ThreadLocal();

	public void getTh() {
		System.out.println("�߳�"+Thread.currentThread().getName()+"  "+ this.th.get());
	}

	public  void setTh(String value) {
		th.set(value);
	}
	 public static void main(String[] args) {
		 
		 ThreadLocalTest tl = new ThreadLocalTest();
	
		 new Thread( () ->  {
			 tl.setTh("wpx");
			 tl.getTh();
		 }).start();
		 	
		 new Thread( () -> {
			 try {
				Thread.sleep(3000);
				tl.getTh();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }) .start();
		 
	 }
	
}
