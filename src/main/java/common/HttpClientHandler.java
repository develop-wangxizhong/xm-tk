package common;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import ticket.SSL;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wangxizhong on 2017/3/13.
 */
public class HttpClientHandler {
    private static PoolingHttpClientConnectionManager cm;
    private static String EMPTY_STR = "";
    private static String UTF_8 = "UTF-8";

    private static CloseableHttpClient client = null;

    private static void initHttpClientConnectionPool() {
        if (cm == null) {
            cm = new PoolingHttpClientConnectionManager();
            cm.setMaxTotal(50);// max connection by pool
            cm.setDefaultMaxPerRoute(5);// route max connection,default 2
        }
    }

    /**
     * get HttpClient from pool
     *
     * @return
     */
    private static CloseableHttpClient getHttpClient() {
        initHttpClientConnectionPool();
        if (client == null) {//single
          /*  SSLContext sslcontext = SSL.createIgnoreVerifySSL();

            // 设置协议http和https对应的处理socket链接工厂的对象
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", new SSLConnectionSocketFactory(sslcontext))
                    .build();
            PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            HttpClients.custom().setConnectionManager(connManager);

            //创建自定义的httpclient对象
            client = HttpClients.custom().setConnectionManager(connManager).build();*/
            client = HttpClients.custom().setConnectionManager(cm).build();
            return client;
        }
        return client;
    }

    /**
     * @param url
     * @return
     */
    public static Map httpGetRequest(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        return getResult(httpGet);
    }

    public static Map httpGetRequest(String url, Map<String, Object> params) throws IOException, URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setPath(url);

        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        uriBuilder.setParameters(pairs);

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        return getResult(httpGet);
    }

    public static Map httpGetRequest(String url, Map<String, Object> headers, Map<String, Object> params)
            throws URISyntaxException, IOException {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setPath(url);

        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        uriBuilder.setParameters(pairs);

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }
        return getResult(httpGet);
    }

    public static Map httpPostRequest(String url) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        return getResult(httpPost);
    }

    public static Map httpPostRequest(String url, Map<String, Object> params) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        return getResult(httpPost);
    }

    public static Map httpPostRequest(String url, Map<String, Object> headers, Map<String, Object> params)
            throws IOException {
        HttpPost httpPost = new HttpPost(url);


        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }

        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        return getResult(httpPost);
    }

    private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
        ArrayList<NameValuePair> pairs = params.entrySet().stream().map(param -> new BasicNameValuePair(param.getKey(),
                String.valueOf(param.getValue()))).collect(Collectors.toCollection(ArrayList::new));

        return pairs;
    }

    /**
     * handler Http request
     *
     * @param request
     */
    private static Map getResult(HttpRequestBase request) throws IOException {
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();

        String responseEntity = EntityUtils.toString(entity);
        Map responseMap = new HashMap();
        responseMap.put("code", response.getStatusLine().getStatusCode());
        responseMap.put("entity", responseEntity);
        responseMap.put("responseInfo", response.toString());

        System.out.println("-----------response:" + response.toString());
        response.close();
        return responseMap;
    }

}
