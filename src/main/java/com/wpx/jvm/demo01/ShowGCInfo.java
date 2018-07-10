package com.wpx.jvm.demo01;
/**
 * 
 * -Xms5m -- ����java��������ʱ�ĳ�ʼ�Ѵ�СΪ5m
 * -Xmx20m -- ����java�����ܻ�õ����Ѵ�СΪ20m
 * -XX:+PrintGCDetails -- ��ӡGC������Ϣ
 * -XX:+UseSeriaiGC -- ���ô��л�����
 * -XX:+PrintCommandLineFlags -- ���Խ���ʽ������ʾ����������Ĳ������ 
 * �鿴GC��Ϣ
 * @author wangpx
 */
public class ShowGCInfo {
	//-Xms5m -Xmx20m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:+PrintCommandLineFlags

	public static void main(String[] args) {
		 System.out.println("maxMemory: "+Runtime.getRuntime().maxMemory());  
	        System.out.println("freeMemory: "+Runtime.getRuntime().freeMemory());  
	        System.out.println("totalMemory"+Runtime.getRuntime().totalMemory());  
	          
	        byte[] b1=new byte[1*1024*1024];  
	        System.out.println("������1M�ڴ�");  
	        System.out.println("maxMemory: "+Runtime.getRuntime().maxMemory());  
	        System.out.println("freeMemory: "+Runtime.getRuntime().freeMemory());  
	        System.out.println("totalMemory"+Runtime.getRuntime().totalMemory());  
	      
	        byte[] b2=new byte[(int) (4.5*1024*1024)];  
	        System.out.println("������4.5M�ڴ�");  
	        System.out.println("maxMemory: "+Runtime.getRuntime().maxMemory());  
	        System.out.println("freeMemory: "+Runtime.getRuntime().freeMemory());  
	        System.out.println("totalMemory"+Runtime.getRuntime().totalMemory());  
	}
}
