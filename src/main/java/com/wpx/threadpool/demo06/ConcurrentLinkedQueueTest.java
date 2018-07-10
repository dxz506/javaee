package com.wpx.threadpool.demo06;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ConcurrentLinkedQueue:
 * �����ڸ߲��������µĶ���,ͨ�������ķ�ʽ,ʵ���˸߲���״̬�µĸ�����,ͨ�������ConcurrentQueue���ܺ���BlockingQueue
 * ����һ���������ӽڵ���޽��̰߳�ȫ����,�ö��е�Ԫ����ѭ�Ƚ��ȳ���ԭ��,�ö��в�����nullԪ��
 * 
 * ConcurrentLinkedQueue����Ҫ����
 * add()��offer()���Ǽ���Ԫ�صķ���,��ConcurrentLinkedQueue������������û������
 * poll()��peek()����ȡͷԪ�ؽڵ�,��������ǰ�߻�ɾ��Ԫ��,���߲���
 * 
 * @author wangpx
 */
public class ConcurrentLinkedQueueTest {

	public static void main(String[] args) {
		//����concurrentLinkedQueue
		ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>();
		//����������Ԫ��
		concurrentLinkedQueue.add("value01");
		concurrentLinkedQueue.offer("value02");
		
		//�Ӷ������Ƴ�Ԫ��
		String poll = concurrentLinkedQueue.poll();
		System.out.println(poll);
		System.out.println(concurrentLinkedQueue.size());
		
		String peek = concurrentLinkedQueue.peek();
		System.out.println(peek);
		System.out.println(concurrentLinkedQueue.size());
	}
}
