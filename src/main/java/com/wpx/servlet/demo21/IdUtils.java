package com.wpx.servlet.demo21;

import java.util.UUID;

/**
 * ���������ض�id
 * 
 * @author wangpx
 */
public class IdUtils {

	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
