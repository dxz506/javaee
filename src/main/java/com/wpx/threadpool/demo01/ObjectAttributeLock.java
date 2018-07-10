package com.wpx.threadpool.demo01;
/**
 * 
 * �������Ե��޸Ĳ���Ӱ��������
 * 
 * @author wangpx
 */
public class ObjectAttributeLock {

	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public synchronized void changeAttribute(String name,int age) {
		try {
			System.out.println("��ǰ�߳� "+Thread.currentThread().getName()+ " ��ʼִ��....");
			this.setAge(age);
			this.setName(name);
			Thread.sleep(3000);
			System.out.println("��ǰ�߳�"+Thread.currentThread().getName()+" ִ�����.....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final ObjectAttributeLock oal = new ObjectAttributeLock();
		new Thread( () -> { oal.changeAttribute("wangpx", 21); }) .start();
		Thread.sleep(3000);
		new Thread( () -> { oal.changeAttribute("wangpx", 22); }) .start();
	}
	
	
}
