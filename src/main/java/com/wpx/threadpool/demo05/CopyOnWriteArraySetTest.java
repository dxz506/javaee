package com.wpx.threadpool.demo05;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Ӧ�ó���Ϊ����д��
 * 
 * @author wangpx
 */
public class CopyOnWriteArraySetTest {

	public static void main(String[] args) {
		//����copyOnWriteArraySet
		CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
		//��copyOnWriteArraySet�����Ԫ��
		copyOnWriteArraySet.add("value01");
		copyOnWriteArraySet.add("value02");
		//����copyOnWriteArraySet����
		for(String s : copyOnWriteArraySet) {
			System.out.println(s);
		}
		
	}
}
