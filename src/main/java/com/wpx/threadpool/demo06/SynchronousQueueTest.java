package com.wpx.threadpool.demo06;

import java.util.concurrent.SynchronousQueue;

/**
 *   SynchronousQueueͬ������:һ��û�л���Ķ���,����������������ֱ�ӻᱻ�����߻�ȡ������
 * �������û������
 * 
 * @author wangpx
 */
public class SynchronousQueueTest {

	public static void main(String[] args) {
		//����synchronousQueue����
		SynchronousQueue<Object> synchronousQueue = new SynchronousQueue<>();
		//���Ԫ��
		synchronousQueue.add(args);
	}
}
