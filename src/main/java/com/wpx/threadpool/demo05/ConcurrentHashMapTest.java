package com.wpx.threadpool.demo05;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 *  ͬ��������:��Vector,HashTable��Щ������ͬ��������ʵ����JDK��Collections,synchronized�ȹ�����������ʵ��
 * 
 *  ͬ�������������̰߳�ȫ��,��ĳЩ��������Ҫ�����������ϲ���
 *  ��:����(��������Ԫ��,�����������е�����Ԫ��)
 *  ��ת(���ݵ�ǰԪ�ذ����ض�˳��ȥ������һ��Ԫ��)
 * 
 *  ConcurrentMap�ӿ���������Ҫ��ʵ��
 *	ConcurrentHashMap
 *  ConcurrentSkipListMap (֧�ֲ���������,�ֲ�ConcurrentMapHashMap)
 * 
 *  ConcurrentHashMap�ڲ�ʹ�ö�����ʾ��Щ��ͬ�Ĳ���,ÿ������ʵ����һ��С��HashTale�������Լ�����
 *  ֻҪ����޸Ĳ��������ڲ�ͬ�Ķ���,���ǾͿ��Բ����ļ���,��һ������ֳ���16����,Ҳ�������֧��16���̵߳Ĳ����޸Ĳ���
 *  ��Ҳ���ڶ��̳߳���ʱ���������ȴӶ�������������һ�ַ���,����๲�����ʹ��volatile�ؼ�������,����ʵʱ�Ļ���޸ĵ�����
 * 
 * @author wangpx
 */
public class ConcurrentHashMapTest {

	public static void main(String[] args) {
		//����ConcurrentHashMap
		ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<String,Object>();
		//��concurrentHashMap�����Ԫ��
		concurrentHashMap.put("key01", "value01");
		//���key01�����������,�������
		concurrentHashMap.putIfAbsent("key01", "valueֵ");
		//����concurrentHashMap
		for(Map.Entry<String,Object> m : concurrentHashMap.entrySet() ) {
			System.out.println("key is "+m.getKey() +" and value is "+m.getValue());
		}
	}
}
