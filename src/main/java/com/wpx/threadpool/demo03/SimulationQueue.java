package com.wpx.threadpool.demo03;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ͨ��ʹ��wait/notify��ģ��һ�������Ķ���(BLocking Queue)
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class SimulationQueue {

	private LinkedList<Object> list =new LinkedList<>();
	
	private int minSize = 0;
	
   AtomicInteger count =new AtomicInteger(0);
	
	private final int maxSize;
	
	public SimulationQueue(int maxSize) {
		this.maxSize= maxSize;
	}
	private final Object lock = new Object();
	
	//������з������
	public void putObject(Object obj) {
		synchronized (lock) {
			while( count.get() == maxSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.add(obj);
			count.incrementAndGet();
			System.out.println("����ӵ�Ԫ��Ϊ" +obj);
			lock.notify();
		}
	}
	//�Ӷ�����ȡ������
	public Object takeObject() {
		Object result = null;
		synchronized (lock) {
			while( count.get() == minSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			result = list.removeFirst();
			count.decrementAndGet();
			System.out.println("�Ƴ���Ԫ��Ϊ"+result);
			lock.notify();
		}
		return result;
	}
	//��ȡ��ǰ���д�С
	public int getSize() {
		return this.count.get();
	}

	public static void main(String[] args) {
		SimulationQueue sq = new SimulationQueue(5);
		for(int i = 0;i < 5; i++) {
			sq.putObject(i+"");
		}
		System.out.println("�����ж�������Ϊ: "+sq.getSize());
		
		new Thread( () ->  {
			sq.putObject("6");
			sq.putObject("7");
			System.out.println("�����ж�������Ϊ: "+sq.getSize());
		}).start();
		
		new Thread( () ->  {
			 String object = (String) sq.takeObject();
			 System.out.println(object + "Ԫ�ر��Ƴ�...");
		} ).start();
	
	}


}
