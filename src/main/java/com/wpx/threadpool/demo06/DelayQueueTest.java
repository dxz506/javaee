package com.wpx.threadpool.demo06;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 *  DelayQueue�����ӳ�ʱ���Queue,���е�Ԫ��ֻ�е�ָ�����ӳ�ʱ�䵽��,���ܹ��Ӷ����л�ȡ����Ԫ��
 	DelayQueue�е�Ԫ�ر���ʵ��Dalayed�ӿ�
 	DelayQueueû�д�С����
 	DelayQueueӦ�ó���: �Ի��泬ʱ�������Ƴ�,����ʱ����,�������ӵĹر�
 	
 * 
 * @author wangpx
 */
public class DelayQueueTest implements Runnable{

	private DelayQueue<WangMin> queue =new DelayQueue<WangMin>();
	private boolean yingye=true;
	
	public void shangji(String name,Integer id,int money) {
	
		WangMin wangMin = new WangMin(id, name, 1000*money+System.currentTimeMillis());
		System.out.println("����Ϊ"+wangMin.getName()+" ���֤Ϊ "+wangMin.getId()+" ��Ǯ "+money+" �鿪ʼ����");
		this.queue.add(wangMin);
	}
	public void xiaji(WangMin wangMin) {
		System.out.println("����Ϊ "+wangMin.getName()+" ���֤Ϊ "+wangMin.getId()+" �»��� ");
	}
	
	@Override
	public void run() {
		while(yingye) {
			try {
				WangMin wangMin = queue.take();
				xiaji(wangMin);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("���ɿ�ʼӪҵ....");
		DelayQueueTest dq = new DelayQueueTest();
		Thread shangwang = new Thread(dq);
		shangwang.start();
		dq.shangji("wangpx", 1, 1);
		dq.shangji("wpx", 2, 2);
		
	}
}
/**
 * ����ʵ����
 * 
 * @author wangpx
 */
class WangMin implements Delayed{

	private Integer id;
	private String name;
	private long endTime;
	private TimeUnit timeUnit=TimeUnit.SECONDS;
	public WangMin() {
	}
	public WangMin(Integer id, String name, long endTime) {
		super();
		this.id = id;
		this.name = name;
		this.endTime = endTime;
	}


	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@Override
	public int compareTo(Delayed delayed) {
		WangMin wangMin = (WangMin) delayed;
		return this.getDelay(this.timeUnit) - wangMin.getDelay(this.timeUnit) > 0 ? 1 :0 ;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return endTime - System.currentTimeMillis() ;
	}
	
}