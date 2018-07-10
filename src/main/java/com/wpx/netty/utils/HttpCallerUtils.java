package com.wpx.netty.utils;


import java.io.IOException;
import java.util.Map;

/**
 * <B>ϵͳ���ƣ�</B>ͨ��ϵͳ����<BR>
 * <B>ģ�����ƣ�</B>���罻������<BR>
 * <B>����������</B>HTTPЭ�������������<BR>
 * <B>��Ҫ˵����</B><BR>
 * 
 * @author ��ͨ���䲿�滮�о�Ժ���ۏ���
 * @since 2013-7-18
 */
public final class HttpCallerUtils {

    /**
     * <B>���췽��</B><BR>
     */
    private HttpCallerUtils() {
    }

    /**
     * <B>�������ƣ�</B>Ĭ������<BR>
     * <B>��Ҫ˵����</B><BR>
     * 
     * @param url URL��ַ
     * @param params ����
     * @return String �ı�����
     * @throws IOException ��������쳣
     */
    public static String request(String url, Map<String, String> params) throws IOException {
        HttpCaller c = new HttpCaller(url, HttpCaller.REQUEST_METHOD_POST, params);
        return c.request(String.class);
    }

    /**
     * <B>�������ƣ�</B>GET����<BR>
     * <B>��Ҫ˵����</B><BR>
     * 
     * @param url URL��ַ
     * @param params ����
     * @return String �ı�����
     * @throws IOException ��������쳣
     */
    public static String get(String url, Map<String, String> params) throws IOException {
        HttpCaller c = new HttpCaller(url, HttpCaller.REQUEST_METHOD_GET, params);
        return c.request(String.class);
    }
    
    public static byte[] getStream(String url, Map<String, String> params) throws IOException {
    	HttpCaller c = new HttpCaller(url, HttpCaller.REQUEST_METHOD_GET, true, params);
	 	return c.request(Byte.class);
    }
    
    /**
     * <B>�������ƣ�</B>POST����<BR>
     * <B>��Ҫ˵����</B><BR>
     * 
     * @param url URL��ַ
     * @param params ����
     * @return String �ı�����
     * @throws IOException ��������쳣
     */
    public static String post(String url, Map<String, String> params) throws IOException {
        HttpCaller c = new HttpCaller(url, HttpCaller.REQUEST_METHOD_POST, params);
        return c.request(String.class);
    }
    
    public static byte[] postStream(String url, Map<String, String> params) throws IOException {
    	HttpCaller c = new HttpCaller(url, HttpCaller.REQUEST_METHOD_POST, true, params);
	 	return c.request(Byte.class);
    }


    /**
     * <B>�������ƣ�</B>PUT����<BR>
     * <B>��Ҫ˵����</B><BR>
     * 
     * @param url URL��ַ
     * @param params ����
     * @return String �ı�����
     * @throws IOException ��������쳣
     */
    public static String put(String url, Map<String, String> params) throws IOException {
        HttpCaller c = new HttpCaller(url, HttpCaller.REQUEST_METHOD_PUT, params);
        return c.request(String.class);
    }

    /**
     * <B>�������ƣ�</B>DELETE����<BR>
     * <B>��Ҫ˵����</B><BR>
     * 
     * @param url URL��ַ
     * @param params ����
     * @return String �ı�����
     * @throws IOException ��������쳣
     */
    public static String delete(String url, Map<String, String> params) throws IOException {
        HttpCaller c = new HttpCaller(url, HttpCaller.REQUEST_METHOD_DELETE, params);
        return c.request(String.class);
    }
}
