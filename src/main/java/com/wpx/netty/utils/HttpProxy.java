package com.wpx.netty.utils;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpProxy {
	private static class SingletonHolder {
		static final HttpProxy instance = new HttpProxy();
	}

	public static HttpProxy getInstance() {
		return SingletonHolder.instance;
	}

	private static CloseableHttpClient httpClient;
	
	private static final String CONTENT_TYPE_JSON = "application/json";

	static {
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(HttpProxyConfig.MAX_TOTAL_CONNECTIONS);
		cm.setDefaultMaxPerRoute(HttpProxyConfig.MAX_ROUTE_CONNECTIONS);
		
		
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(HttpProxyConfig.CONNECT_TIMEOUT)
		        .setConnectTimeout(HttpProxyConfig.CONNECT_TIMEOUT)
		        .build();
		//����
		/*		
 		CacheConfig cacheConfig = CacheConfig.custom()
	            .setMaxCacheEntries(1000)
	            .setMaxObjectSize(8192)
	            .build();
	    */
		httpClient = HttpClients.custom()
				.setDefaultRequestConfig(requestConfig)
				.setConnectionManager(cm)
				.build();
	}

	public static HttpClient getHttpClient() {
		return httpClient;
	}
	
	/**
	 * <B>�������ƣ�</B><BR>
	 * <B>��Ҫ˵����</B><BR>
	 * @param requestUrl ����·��
	 * @return �ֽ�����
	 * @throws Exception
	 */
	public static byte[] get4Stream(String requestUrl) throws Exception {
		byte[] ret = null;
	    HttpGet httpGet = new HttpGet(requestUrl);
	    CloseableHttpResponse response = httpClient.execute(httpGet);
	    try {
	        HttpEntity entity = response.getEntity();
	        if (entity != null) {
	            long len = entity.getContentLength();
	            ret =  EntityUtils.toByteArray(entity);
	            EntityUtils.consume(entity);
	        }
	        return ret;
	    } finally {
	        response.close();
	    }	 
	}
	
	/**
	 * <B>�������ƣ�</B><BR>
	 * <B>��Ҫ˵����</B><BR>
	 * @param requestUrl ����·��
	 * @return �ַ���
	 * @throws Exception
	 */
	public static String get4String(String requestUrl) throws Exception {
		String ret = null;
	    HttpGet httpGet = new HttpGet(requestUrl);
	    CloseableHttpResponse response = httpClient.execute(httpGet);
	    try {
	        HttpEntity entity = response.getEntity();
	        if (entity != null) {
	            long len = entity.getContentLength();
	            ret =  EntityUtils.toString(entity);
	            EntityUtils.consume(entity);
	        }
	        return ret;
	    } finally {
	        response.close();
	    }	 
	}
	
	/**
	 * <B>�������ƣ�</B>��ͨ����<BR>
	 * <B>��Ҫ˵����</B>��ͨ����<BR>
	 * @param requestUrl ����·��
	 * @param requestContent ��������
	 * @return ������Ӧ���
	 * @throws IOException
	 */
	public static String post(String requestUrl, String requestContent) throws IOException {
		StringEntity requestEntity = new StringEntity(requestContent, Consts.UTF_8);
		return execute(requestUrl,requestEntity);
	}
	
	/**
	 * <B>�������ƣ�</B>json����<BR>
	 * <B>��Ҫ˵����</B>json����<BR>
	 * @param requestUrl ����·��
	 * @param jsonContent  json����
	 * @return ������Ӧ���
	 * @throws IOException
	 */
	public static String postJson(String requestUrl, String jsonContent) throws IOException {
		StringEntity requestEntity = new StringEntity(jsonContent, Consts.UTF_8);
		requestEntity.setContentEncoding("UTF-8");    
		requestEntity.setContentType(CONTENT_TYPE_JSON);  
		return execute(requestUrl,requestEntity);
	}

	/**
	 * <B>�������ƣ�</B>ģ����ϴ�<BR>
	 * <B>��Ҫ˵����</B>ģ����ϴ�<BR>
	 * @param requestUrl ����·��
	 * @param params ���Բ���
	 * @return ������Ӧ���
	 * @throws IOException
	 */
	public static String post(String requestUrl, Map<String, String> params) throws IOException {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (params != null) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		EntityBuilder builder = EntityBuilder.create();
		builder.setParameters(nvps);
		HttpEntity httpEntity = builder.build();
		return execute(requestUrl,httpEntity);
	}
	
	/**
	 * <B>�������ƣ�</B>�ϴ��ļ�<BR>
	 * <B>��Ҫ˵����</B>�ϴ��ļ�<BR>
	 * @param requestUrl ����·��
	 * @param localFile  �ļ�λ��
	 * @param username 	  �û���
	 * @param password 	  ����
	 * @return ��Ӧ��Ϣ
	 * @throws IOException
	 */
	public static String upload(String requestUrl, String localFile, String username, String password) throws IOException {
        HttpPost httpPost = new HttpPost(requestUrl);
        // ���ļ�ת����������FileBody
        FileBody fileBody = new FileBody(new File(localFile));
        StringBody usernameInp = new StringBody(username, ContentType.create("text/plain", Consts.UTF_8));
        StringBody passwordInp = new StringBody(password, ContentType.create("text/plain", Consts.UTF_8));
        HttpEntity httpEntity = MultipartEntityBuilder.create()
                // �൱��<input type="file" name="file"/>
                .addPart("file", fileBody)
                // �൱��<input type="text" name="userName" value=userName>
                .addPart("username", usernameInp)
                .addPart("password", passwordInp)
                .build();
        return execute(requestUrl,httpEntity);
	}
	
	/**
	 * <B>�������ƣ�</B>ִ�����󷽷�<BR>
	 * <B>��Ҫ˵����</B>ִ�����󷽷�<BR>
	 * @param requestUrl ����·��
	 * @param httpEntity ����ʵ�����
	 * @return ������Ӧ���
	 * @throws IOException
	 */
	private static String execute(String requestUrl, HttpEntity httpEntity) throws IOException {
		String result = null;
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.setEntity(httpEntity);	
		try {
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			try {
				HttpEntity entity = httpResponse.getEntity();
				//System.out.println(httpResponse.getStatusLine().getStatusCode());
				if (httpResponse.getStatusLine().getReasonPhrase().equals("OK") && httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					result = EntityUtils.toString(entity, "UTF-8");
				}
				//��������
				EntityUtils.consume(entity);
			} finally {
				if (null != httpResponse) {
					httpResponse.close();
				}
			}
		} finally {
			if (null != httpPost) {
				httpPost.releaseConnection();
			}
		}
		return result;
	}
	

	
}
