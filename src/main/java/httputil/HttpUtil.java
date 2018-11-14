package httputil;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Reporter;
import testcase.store_web_activity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * http请求的工具类
 */
public class HttpUtil {

    private static final Log log = new Log(HttpUtil.class);

    /**
     * http的post请求方法,包含请求头和请求体
     * @param url 请求接口的路径
     * @param bodyMap 请求体map
     * @return  服务器响应的JSON格式的数据
     * @throws Exception
     */

    public static JSONObject sendPost(String url,HashMap<String,Object> HEADER, HashMap<String,Object> bodyMap){
        CloseableHttpClient httpClient = HttpClients.createDefault();// 创建默认的httpClient实例
        HttpPost post = new HttpPost(url);
        Set<String> set = HEADER.keySet();
        for(String key : set){
            post.addHeader(key, HEADER.get(key).toString());
        }
        JSONObject bodyJson = new JSONObject(bodyMap);
        ContentType contentType = ContentType.create("application/json","utf-8");//通过Json方式请求
        HttpEntity entity = new StringEntity(bodyJson.toString(),contentType);
        post.setEntity(entity);
        CloseableHttpResponse httpResponse = null;
        String result = null;
        try {
            httpResponse = httpClient.execute(post);
            HttpEntity resultEntity = httpResponse.getEntity();
            result = EntityUtils.toString(resultEntity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("发送请求出现异常:");
        }
        return getResultJson(result);
    }

    /**
     * 输出信息
     * */
    public void print(String s){
        System.out.println(s);
    }

    public static String sendGet(String url, HashMap<String,Object> HEADER,String param) throws UnsupportedEncodingException {
        CloseableHttpClient httpClient = HttpClients.createDefault();// 创建默认的httpClient实例
        HttpGet get = new HttpGet(url);
        Set<String> set = HEADER.keySet();
        for(String key : set){
            get.addHeader(key, HEADER.get(key).toString());
        }
        CloseableHttpResponse httpResponse = null;
        String result = null;
        try {
            httpResponse = httpClient.execute(get);
            HttpEntity resultEntity = httpResponse.getEntity();
            result = EntityUtils.toString(resultEntity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("发送请求出现异常:");
        }
        return result;
    }

    /**
     * 把服务器返回的结果做判断，最终返回一个JSONObject
     * @param result  服务器返回的响应结果字符串
     * @return 返回一个JSONObject
     */
    public static JSONObject getResultJson(String result){
        log.info("响应数据：-------"+result);
        Reporter.log("响应数据：-------"+result);
        try{
            return JSONObject.parseObject(result);
        }catch (Exception e){
            log.error("返回的响应数据不是json格式");
            if(result.contains("HTTP Status")){
                String status = result.substring(result.indexOf("HTTP Status"),result.indexOf(" - Request"));
                String resultJson = "{\"status\":"+"\""+status+"\""+"}";
                log.error("响应的请求状态码是： "+status);
                return null;
            }
            return null;
        }
    }
}