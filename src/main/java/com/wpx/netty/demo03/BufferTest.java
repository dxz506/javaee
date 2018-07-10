package com.wpx.netty.demo03;
import java.nio.IntBuffer;

import org.junit.Test;
/**
 * ������:ԭ������Ϊֱ������,���������뻺����,
 * 
 * @author wangpx
 */
public class BufferTest {

	/**
	 * buffer�Ľṹ
	 */
	@Test
	public void demo01() {
		//����ָ�����ȵĻ�����
		IntBuffer buffer =IntBuffer.allocate(10);
		buffer.put(12); //position��λ�� : 0 -> 1
		buffer.put(21); //position��λ�� :	1 -> 2
		buffer.put(33); //position��λ��: 2 -> 3
		//��position��λ�ø�λΪ0 
		System.out.println("��λǰ"+buffer);
		buffer.flip();
		System.out.println("��λ��"+buffer);
	}
	
	@Test
	public void demo02() {
		//����ָ�����ȵĻ�����
		IntBuffer buffer =IntBuffer.allocate(10);
		buffer.put(12); //position��λ�� : 0 -> 1
		buffer.put(21); //position��λ�� :	1 -> 2
		buffer.put(33); //position��λ��: 2 -> 3
		
		buffer.flip();
		System.out.println("��ȡ�±�Ϊ1 ��Ԫ�� "+buffer.get(1));
		System.out.println("get(index����)����,positionλ�ò��ı�"+buffer);
		buffer.put(1, 4);
		System.out.println("put(index,change)����,positionλ�ò���"+buffer);
	}
	/**
	 * get(index)
	 * put(index,change)
	 * get()
	 */
	@Test
	public void demo03() {
		//����ָ�����ȵĻ�����
		IntBuffer buffer =IntBuffer.allocate(10);
		buffer.put(12); //position��λ�� : 0 -> 1
		buffer.put(21); //position��λ�� :	1 -> 2
		buffer.put(33); //position��λ��: 2 -> 3
		
		buffer.flip();
		for(int i=0;i<buffer.limit();i++) {
			//����get������ʹ�仺����λ��(position)������һλ
			System.out.println(buffer.get()+"\t");
		}
		System.out.println("buffer�������֮��Ϊ: "+buffer);
	}
	
	/**
	 * wrap����
	 * wrap���������һ������,warp�����޸Ļ����������ʱ��,���鱾��Ҳ����ŷ����仯
	 * 
	 */
	@Test
	public void demo04(){
		//�½�һ����
		int[] arr =new int[] {1,2,3};
		IntBuffer buffer = IntBuffer.wrap(arr);
		System.out.println(buffer);
		
		IntBuffer buffer2 = IntBuffer.wrap(arr, 0, 2);
		System.out.println(buffer2);
	}
	
	/**
	 * ��������
	 * 
	 */
	
	@Test
	public void demo05() {
		IntBuffer buffer = IntBuffer.allocate(10);
		int[] arr = new int[] {1,2,3,4};
		buffer.put(arr);
		System.out.println(buffer);
		//һ�ָ��Ƶķ���
		IntBuffer buffer2 = buffer.duplicate();
		System.out.println(buffer2);
		
		//����buffer��λ������
		buffer.position(0);
		System.out.println(buffer);
		buffer2.flip();
		System.out.println(buffer2);
	
		
		System.out.println("�ɶ�����Ϊ"+buffer.remaining());
		System.out.println("�ɶ�����Ϊ"+buffer2.remaining());
		
		
	}
	
	
}
