package com.wpx.threadpool.demo08;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 *  * Executors�����̳߳ط���
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class ExecutorsTest {

	/**
	 *  	 newFixedThreadPool()����,�÷�������һ���������̳߳�,�÷������߳���ʼ�ղ���
	 * ����һ�������ύʱ ,���̳߳��п���,������ִ��,��û��,��ᱻ�ݻ���һ����������еȴ����е��߳�ִ��
	 * @param nThreads
	 */
	@Test
	public void newFixedThreadPoolDemo(int nThread) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(nThread);
		//new ThreadPoolExecutor(nThread, nThread, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	
	}
	/**
	 *  * newSingleThreadExecutor()�� ��,����һ���̵߳��̳߳�,��������ִ��,��û�п����߳����ݻ������������
	 */
	@Test
	public void newSingleThreadExcutorTest() {
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		//new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	}
	/**
	 *  * newCacheThreadPool()����,����һ���ɸ���ʵ����������̸߳������̳߳�,����������߳�����
	 	* ���п��е��߳���ִ������,�����򲻴����̲߳��ҿ����̻߳�60����Զ�����
	 */
	@Test
	public void newCacheThreadPoolTest() {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		//new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());
	}
	/**
	 *  * newScheeduledThreadPool(),�÷�������һ�� SchedeExecutorService����
     *    �����߳̿���ָ���̵߳����� corePoolSize
	 */
	@Test
	public void ScheduledThreadPoolTest(int corePoolSize) {
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(corePoolSize);
		//DelayQueue�����ж�����Ҫʵ��Delayed�ӿ�
		//new ThreadPoolExecutor(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS, new DelayQueue<>());
	}
}
