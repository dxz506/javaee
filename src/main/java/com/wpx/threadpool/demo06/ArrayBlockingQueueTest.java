package com.wpx.threadpool.demo06;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 
 *   BlockingQueue�ӿ�
 * 
 *   ArrayBlockQueue:�����������������ʵ��,��ArrayBlockQueue�ڲ�,ά����һ������������,
 *   ���ڻ�������е����ݶ���,,���ڲ�û��ʵ�ֶ�д����,Ҳ����ζ�����������Ѳ�����ȫ����,������Ҫ����,
 *   ����ָ���Ƚ��ȳ������Ƚ����,Ҳ���н����
 * 
 * @author wangpx
 */
public class ArrayBlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		//����arrayBlockingQueue
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(4);
		//���Ԫ��
		arrayBlockingQueue.add("a");
		arrayBlockingQueue.add("b");
		arrayBlockingQueue.add("c");
		arrayBlockingQueue.add("d");
		//����������Ԫ��  ����ֵΪboolean �����ֱ�Ϊ ���Ԫ�� ,ʱ��,ʱ�䵥λ
		System.out.println(arrayBlockingQueue.offer("e", 1, TimeUnit.SECONDS));
		arrayBlockingQueue.add("error");
	}
}
