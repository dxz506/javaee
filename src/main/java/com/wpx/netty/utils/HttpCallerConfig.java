package com.wpx.netty.utils;


import java.io.Serializable;
import java.util.Map;

/**
 * <B>ϵͳ���ƣ�</B>ͨ��ϵͳ����<BR>
 * <B>ģ�����ƣ�</B>���罻������<BR>
 * <B>����������</B>HTTPЭ�����������<BR>
 * <B>��Ҫ˵����</B><BR>
 * 
 * @author ��ͨ���䲿�滮�о�Ժ���ۏ���
 * @since 2013-7-18
 */
public class HttpCallerConfig implements Serializable {

    /** Ĭ�ϰ汾Ψһ��ʶ */
    private static final long serialVersionUID = 1L;

    /** Ĭ�����ã��ַ��� */
    public static final String DEFAULT_CONFIG_CHARSET = "UTF-8";

    /** Ĭ�����ã����ӳ�ʱ�����룩 */
    public static final int DEFAULT_CONFIG_CONN_TIMEOUT = 30000;

    /** Ĭ�����ã���ȡ��ʱ�����룩 */
    public static final int DEFAULT_CONFIG_READ_TIMEOUT = 30000;

    /** Ĭ�����ã���󻺳��С���ַ�/�ֽ����� */
    public static final int DEFAULT_CONFIG_MAX_BUFFER_SIZE = 500;

    /** URL��ַ */
    private String url;

    /** ���󷽷� */
    private String method;

    /** �ַ��� */
    private String charset = DEFAULT_CONFIG_CHARSET;

    /** ���ӳ�ʱ�����룩 */
    private int connTimeout = DEFAULT_CONFIG_CONN_TIMEOUT;

    /** ��ȡ��ʱ�����룩 */
    private int readTimeout = DEFAULT_CONFIG_READ_TIMEOUT;

    /** ��󻺳��С���ַ����� */
    private int maxBufferSize = DEFAULT_CONFIG_MAX_BUFFER_SIZE;

    /** ���� */
    private Map<String, String> params;
    
    /** �Ƿ��ȡΪ��������Ϣ */
    private boolean isStream ;

    /**
     * <B>ȡ�ã�</B>URL��ַ<BR>
     * 
     * @return String URL��ַ
     */
    public String getUrl() {
        return url;
    }

    /**
     * <B>�趨��</B>URL��ַ<BR>
     * 
     * @param url URL��ַ
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * <B>ȡ�ã�</B>���󷽷�<BR>
     * 
     * @return String ���󷽷�
     */
    public String getMethod() {
        return method;
    }

    /**
     * <B>�趨��</B>���󷽷�<BR>
     * 
     * @param method ���󷽷�
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * <B>ȡ�ã�</B>�ַ���<BR>
     * 
     * @return String �ַ���
     */
    public String getCharset() {
        return charset;
    }

    /**
     * <B>�趨��</B>�ַ���<BR>
     * 
     * @param charset �ַ���
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * <B>ȡ�ã�</B>���ӳ�ʱ�����룩<BR>
     * 
     * @return int ���ӳ�ʱ�����룩
     */
    public int getConnTimeout() {
        return connTimeout;
    }

    /**
     * <B>�趨��</B>���ӳ�ʱ�����룩<BR>
     * 
     * @param connTimeout ���ӳ�ʱ�����룩
     */
    public void setConnTimeout(int connTimeout) {
        this.connTimeout = connTimeout;
    }

    /**
     * <B>ȡ�ã�</B>��ȡ��ʱ�����룩<BR>
     * 
     * @return int ��ȡ��ʱ�����룩
     */
    public int getReadTimeout() {
        return readTimeout;
    }

    /**
     * <B>�趨��</B>��ȡ��ʱ�����룩<BR>
     * 
     * @param readTimeout ��ȡ��ʱ�����룩
     */
    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    /**
     * <B>ȡ�ã�</B>��󻺳��С���ַ�/�ֽ�����<BR>
     * 
     * @return int ��󻺳��С���ַ�/�ֽ�����
     */
    public int getMaxBufferSize() {
        return maxBufferSize;
    }

    /**
     * <B>�趨��</B>��󻺳��С���ַ�����<BR>
     * 
     * @param maxBufferSize ��󻺳��С���ַ�/�ֽ�����
     */
    public void setMaxBufferSize(int maxBufferSize) {
        this.maxBufferSize = maxBufferSize;
    }

    /**
     * <B>ȡ�ã�</B>����<BR>
     * 
     * @return Map<String, String> ����
     */
    public Map<String, String> getParams() {
        return params;
    }

    /**
     * <B>�趨��</B>����<BR>
     * 
     * @param params ����
     */
    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public boolean isStream() {
		return isStream;
	}

	public void setStream(boolean isStream) {
		this.isStream = isStream;
	}

	/**
     * <B>�������ƣ�</B>�����ı�<BR>
     * <B>��Ҫ˵����</B><BR>
     * 
     * @return String �ı�
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "HttpCallerConfig [url=" + url + ", method=" + method + ", charset=" + charset + ", connTimeout="
                + connTimeout + ", readTimeout=" + readTimeout + ", maxBufferSize=" + maxBufferSize + ", params="
                + (params == null ? null : params.size()) + "]";
    }

}
