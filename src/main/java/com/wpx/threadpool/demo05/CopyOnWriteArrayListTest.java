package com.wpx.threadpool.demo05;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * @author wangpx
 */
public class CopyOnWriteArrayListTest {

	public static void main(String[] args) {
		//����copyOnWriteArrayList����
		CopyOnWriteArrayList<String> copyOnWriteArrayList = new  CopyOnWriteArrayList<String>();
		//���Ԫ��
		copyOnWriteArrayList.add("value01");
		copyOnWriteArrayList.add("value02");
		//����Ԫ��
		for(String s : copyOnWriteArrayList) {
			System.out.println(s);
		}
	}
}
