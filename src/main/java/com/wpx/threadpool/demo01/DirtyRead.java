package com.wpx.threadpool.demo01;
/**
 * �߳��е����
 * 
 * 
 * �̰߳�ȫ����: ������̷߳���ĳһ����(����򷽷�)��ʱ��,�����ʼ�ն���  ������ȷ����Ϊ,
 * ��ô�����(������Ƿ���)�����̰߳�ȫ��               
 *    synchronized:����������Ķ�����Ƿ����ϼ���,����������δ����Ϊ"������"                
 *             
 *             
 *    ������̷߳���Thread��run����ʱ,�����Ŷӵķ�ʽ�ȴ�cpu����,һ���߳�Ҫ��ִ��synchronized���εķ�����Ĵ���,
 *    ����Ҫ���Ի�������
 *     ����߳�ȥ��ȡ��,ͬ��Ҳ�����������������    
 *     
 *   
 * 
 * @author wangpx
 */
public class DirtyRead {

	private  String username="wpx";
	private  String password="123";

	/**
	 * 
		ֻ��setValue�ϼ�synchronized�ؼ���
		username is : wangpx and password is 123
		setValue�����õ���:username= wangpx  123456
	 */
	public  synchronized  void setValue(String username,String password) {
		this.username=username;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.password=password;
		System.out.println("setValue�����õ���:username= "+this.username+"  "+this.password);
	}
	/**
	 * ��ǰ�������н��
	 * setValue�����õ���:username= wangpx  123456
		username is : wangpx and password is 123456
	 * 
	 */
	public synchronized void getValue() {
		System.out.println("username is : "+username+ " and password is "+password);
	}
	
	public static void main(String[] args) throws InterruptedException {
		DirtyRead dr=new DirtyRead();
		
		Thread t1 = new Thread( () -> {dr.setValue("wangpx", "123456"); } );
		t1.start();
		/**
		
		setValue �� getVlaue ������synchronized�ؼ���
		username is : wangpx and password is 123
		setValue�����õ���:username= wangpx  123456
				 */
		Thread.sleep(1000);
		dr.getValue();
	}
}
