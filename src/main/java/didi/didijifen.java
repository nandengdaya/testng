package didi;

import com.google.common.collect.Lists;
import httputil.didi_sign;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import testcase.TestCase;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * @Author: megan
 * @Date: 2019/1/7 上午10:23
 * @Description:
 **/
public class didijifen {


    @Test
    @TestCase(id = "1001", description = "获取商品编号,直接请求")
    public void getSkuListTestLocal(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Long time = System.currentTimeMillis();
        int page = 1;
        int size = 20;

        List<BasicNameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("time",String.valueOf(time)));
        params.add(new BasicNameValuePair("page",String.valueOf(page)));
        params.add(new BasicNameValuePair("size",String.valueOf(size)));
        String siginStr = didi_sign.createSignOnline(params);
        params.add(new BasicNameValuePair("sign",siginStr));
        HttpPost post = new HttpPost("https://test-api.mobilemart.cn/store-web/didi/product/getSku");
        System.out.println(post);
        try {
            post.setEntity(new UrlEncodedFormEntity(params));

            try {
                CloseableHttpResponse response = httpClient.execute(post);

                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    @Test
    @TestCase(id = "1002", description = "获取商品编号,域名请求")
    public void getSkuListTestDev(){

        CloseableHttpClient httpClient = HttpClients.createDefault();
        Long time = System.currentTimeMillis();
        int page = 1;
        int size = 20;

        List<BasicNameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("time",String.valueOf(time)));
        params.add(new BasicNameValuePair("page",String.valueOf(page)));
        params.add(new BasicNameValuePair("size",String.valueOf(size)));
        String siginStr = didi_sign.createSignOnline(params);
        params.add(new BasicNameValuePair("sign",siginStr));

        HttpPost post = new HttpPost("https://test-api.mobilemart.cn/didi/api/product/getSku");
        System.out.println(post);
        try {
            post.setEntity(new UrlEncodedFormEntity(params));

            try {
                CloseableHttpResponse response = httpClient.execute(post);

                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity));

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


//    @Test
    @TestCase(id = "1003", description = "获取商品编号,生产环境")
    public void getSkuListTestOnline(){

        CloseableHttpClient httpClient = HttpClients.createDefault();
        Long time = System.currentTimeMillis();
        int page = 1;
        int size = 100;

        List<BasicNameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("time",String.valueOf(time)));
        params.add(new BasicNameValuePair("page",String.valueOf(page)));
        params.add(new BasicNameValuePair("size",String.valueOf(size)));
        String siginStr = didi_sign.createSignOnline(params);
        params.add(new BasicNameValuePair("sign",siginStr));

        HttpPost post = new HttpPost("https://api.mobilemart.cn/didi/api/product/getSku");
        try {
            post.setEntity(new UrlEncodedFormEntity(params));

            try {
                CloseableHttpResponse response = httpClient.execute(post);

                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity));

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    @Test
    @TestCase(id = "2001", description = "获取商品详细信息,直接请求")
    public void getDetailTestLocal(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Long time = System.currentTimeMillis();
        String skuId = String.valueOf(366);

        List<BasicNameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("time",String.valueOf(time)));
        params.add(new BasicNameValuePair("skuId",skuId));
        String signStr = didi_sign.createSignOnline(params);
        params.add(new BasicNameValuePair("sign",signStr));

        HttpPost post = new HttpPost("https://test-api.mobilemart.cn/store-web/didi/product/getDetail");
        System.out.println(post);
        try {
            post.setEntity(new UrlEncodedFormEntity(params));

            try {
                CloseableHttpResponse response = httpClient.execute(post);
                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


    @Test
    @TestCase(id = "2002", description = "获取商品详细信息,域名请求")
    public void getDetailTestDev(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Long time = System.currentTimeMillis();
        String skuId = String.valueOf(366);

        List<BasicNameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("time",String.valueOf(time)));
        params.add(new BasicNameValuePair("skuId",skuId));
        String signStr = didi_sign.createSignOnline(params);
        params.add(new BasicNameValuePair("sign",signStr));

        HttpPost post = new HttpPost("https://test-api.mobilemart.cn/didi/api/product/getDetail");
        System.out.println(post);
        try {
            post.setEntity(new UrlEncodedFormEntity(params));

            try {
                CloseableHttpResponse response = httpClient.execute(post);
                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


//    @Test
    @TestCase(id = "2003", description = "获取商品详细信息,生产环境")
    public void getDetailTestOnline(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Long time = System.currentTimeMillis();

//        "name":"驰田香水", "skuId":"380"
//        "name":"小记忆腰靠", "skuId":"373"
//        "name":"斜纹蝴蝶头枕", "skuId":"371"
//        "name":"杰力科速腾三合一数据线", "skuId":"369"
//        "name":"卡百年洗车巾 2条", "skuId":"367"
//        "name":"W型风口手机架", "skuId":"366"

        String skuId = String.valueOf(366);

        List<BasicNameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("time",String.valueOf(time)));
        params.add(new BasicNameValuePair("skuId",skuId));
        String signStr = didi_sign.createSignOnline(params);
        params.add(new BasicNameValuePair("sign",signStr));

        HttpPost post = new HttpPost("https://api.mobilemart.cn/didi/api/product/getDetail");

        try {
            post.setEntity(new UrlEncodedFormEntity(params));

            try {
                CloseableHttpResponse response = httpClient.execute(post);
                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

// --------------------------------------------订单------------------------------------------------------

    @Test
    @TestCase(id = "1004", description = "创建订单,DEV环境")
    public void submitOrder(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Long time = System.currentTimeMillis();
        //  需要每次都不一样
        String didiOrderId = "5bee5ad312a3e2c9450d";
        String skuList = "[{\"num\":1,\"price\":9,\"skuId\":318}]";
        String name = "张三";
        String province = "浙江省";
        String city = "杭州市";
        String county = "西湖区";
        String town = "西斗门路九号";
        String mobile = "15286802819";
        String remark = "";
        String totalPrice = "9";
        String address = "福地创业园4号楼";
        List<BasicNameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("time",String.valueOf(time)));
        params.add(new BasicNameValuePair("didiOrderId",didiOrderId));
        params.add(new BasicNameValuePair("skuList",skuList));
        params.add(new BasicNameValuePair("name",name));
        params.add(new BasicNameValuePair("province",province));
        params.add(new BasicNameValuePair("city",city));
        params.add(new BasicNameValuePair("county",county));
        params.add(new BasicNameValuePair("town",town));
        params.add(new BasicNameValuePair("mobile",mobile));
        params.add(new BasicNameValuePair("remark",remark));
        params.add(new BasicNameValuePair("totalPrice",totalPrice));
        params.add(new BasicNameValuePair("address",address));
        String signStr = didi_sign.createSignOnline(params);
        params.add(new BasicNameValuePair("sign",signStr));

        // https://api.mobilemart.cn/didi/api/order/submitOrder 正式
        // https://dev-api.mobilemart.cn/order-web/didi/order/submitOrder 老的
        HttpPost post = new HttpPost("https://dev-api.mobilemart.cn/store-web/didi/order/submitOrder");
        try {
            post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            try {
                CloseableHttpResponse response = httpClient.execute(post);
                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    @Test
    @TestCase(id = "1005", description = "查看订单,DEV环境")
    public void orderTrack(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Long time = System.currentTimeMillis();
        //  mgo_order_extra 表中获取didiOrderId--->third_order_sn   orderId --->order_sn  必须相互对应
        String didiOrderId = "5bee5ad312a3e2c9450d";
        String orderId = "190109109186072819";
        List<BasicNameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("time",String.valueOf(time)));
        params.add(new BasicNameValuePair("didiOrderId",didiOrderId));
        params.add(new BasicNameValuePair("orderId",orderId));
        String signStr = didi_sign.createSignOnline(params);
        params.add(new BasicNameValuePair("sign",signStr));

        // https://api.mobilemart.cn/didi/api/order/orderTrack 正式
        // https://dev-api.mobilemart.cn/order-web/didi/order/orderTrack 老的
        HttpPost post = new HttpPost("https://dev-api.mobilemart.cn/store-web/didi/order/orderTrack");
        try {
            post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            try {
                CloseableHttpResponse response = httpClient.execute(post);
                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
