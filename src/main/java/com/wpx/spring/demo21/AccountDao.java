package com.wpx.spring.demo21;

public interface AccountDao {
	/**
	 * ת��ķ���
	 * to:Ҫת�����
	 * money:Ҫת��Ľ��
	 */
	public void in(String to,Double money);
	/**
	 * ת���ķ���
	 * from:Ҫת������
	 * money:Ҫת���Ľ��
	 */
	public void out(String from,Double money);
}
