package com.wpx.threadpool.demo07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *  *  Master-Workerģʽ
 *  Master-Workerģʽ�ǳ��õĲ��м���ģʽ,����˼�������������Э������Master��Worker
 *  
 * @author wangpx
 */
public class Master {

	//��װ����ļ���
	private ConcurrentLinkedQueue<Task> workQueue=new ConcurrentLinkedQueue<>();
	//���е�work����
	private HashMap<String,Thread> works = new HashMap<>();
	//workִ������Ľ����
	private ConcurrentHashMap<String,Object> resultMap= new ConcurrentHashMap<>();
	//һ�����췽����ͳ��worker
	public Master(Worker worker,int workCount) {
		worker.setWorkQueue(this.workQueue);
		worker.setResultMap(this.resultMap);
		for(int i=0;i<workCount;i++) {
			works.put("�ڵ�"+Integer.toString(i), new Thread(worker));
		}
	}
	
	//�ύ���� ���������������
	public void submit(Task task) {
		this.workQueue.add(task);
	}
	//ִ�з��� �����е�Worker����
	public void execute() {
		for(Map.Entry<String,Thread> m: works.entrySet()) {
			m.getValue().start();
		}
	}
	//�ж������߳��Ƿ�ִ�����
	public boolean isComplete() {
		for(Map.Entry<String, Thread> m : works.entrySet()) {
			if( m.getValue().getState() != Thread.State.TERMINATED) {
				return false;
			}
		}
		return true;
	}
	public List<Object> getResult(){
		List<Object> list=new ArrayList<>();
		for(Map.Entry<String,Object> m: resultMap.entrySet()) {
			list.add(m);
		}
		return list;
	}
	
}
