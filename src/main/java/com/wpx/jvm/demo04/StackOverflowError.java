package com.wpx.jvm.demo04;
/**
 * 
 * -Xss ջ����
 * 
 * @author wangpx
 */
public class StackOverflowError {
		//-Xss1m  ����������룺22257
		//-Xss5m  ����������룺64995
		
		//ջ�������
		private static int count;
		
		public static void recursion(){
			count++;
			recursion();
		}
		public static void main(String[] args){
			try {
				recursion();
			} catch (Throwable t) {
				System.out.println("����������룺" + count);
				t.printStackTrace();
			}
	}
}
