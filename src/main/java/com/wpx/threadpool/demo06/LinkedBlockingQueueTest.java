package com.wpx.threadpool.demo06;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 
 *   LinkedBlockingQueue:�����������������,,ͬArrayBlockingQueue����,���ڲ�Ҳά����һ�����ݻ������
 *  ���������ݻ������,������һ��������,LinkedBlockingQueue֮�����ܸ�Ч�Ĵ�������������Ϊ���ڲ����÷�����
 *  �Ӷ�ʵ�������ߺ������ߵ���ȫ���д���
 * 
 * @author wangpx
 */
public class LinkedBlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		//����linkedBlockingQueue����
		LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>();
		//��linkedBlockingQueue�����Ԫ��
		linkedBlockingQueue.add("a");
		linkedBlockingQueue.add("b");
		linkedBlockingQueue.add("c");
		System.out.println(linkedBlockingQueue.offer("d", 1, TimeUnit.SECONDS));
		
		ArrayList<String> arrayList = new ArrayList<String>();
		int drainTo = linkedBlockingQueue.drainTo(arrayList,2);
		System.out.println(drainTo);
		System.out.println(linkedBlockingQueue.size());
		System.out.println(arrayList.size());
		
	}
}
