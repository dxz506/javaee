package com.wpx.jvm.demo02;
/**
 * 
 * SurivorRatio������
 * 
 * -Xmn:���������������Ĵ�С( new generation ),��������gc�Ƚ�Ƶ��,һ������Ϊ�����ѿռ��1/3��1/4���� 
 *  -XX:SurvlvoRatio:����������������eden�ռ��form/to�ռ�ı��� 
    -XX:SurvivorRatio=eden/from=eden/to 
    -XX:+printGC ����Gc�ʹ�ӡ
    
    from��to�Ǵ�С�뵽����������
    
	     ��ͬ�Ķѷֲ����,��ϵͳִ�л����һ����Ӱ��,��ʵ�ʹ�����,Ӧ�ø���ϵͳ���ص�������������� 
	    ��������:�����ܽ�����Ԥ����������,�����������GC���� 
	    ���˿��������������ľ��Դ�С(-Xmn)������ʹ��-XX:NewRatio 
	    ��������������ı���
   
 * 
 * @author wangpx
 */
public class SurvivorRatioConfig {

	public static void main(String[] args) {
		// ��һ������
		//-Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC  

		//�ڶ������� ����������
		//-Xms20m -Xmx20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
		

		//����������
		//-Xms20m -Xmx20m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
		
		byte[] b=null;
		for(int i=0;i<10;i++) {
			b=new byte[1024*1024];
		}
		
	}
}
