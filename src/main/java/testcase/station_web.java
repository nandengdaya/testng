package testcase;
/***

 扫码退款-魔急便
 /payment-web/scanpay/refund/orderSn返回的状态码断言的值是"-3"
 因为每笔订单只能退款一次，所以断言的是退款已退过款的状态（-3）

 扫码支付-魔急便
 /scanpay/orderSn/code,传入的参数当天可以成功，第二天就会返回失败，其中有一个参数是微信的支付码，问题原因需要查明

 非特殊说明的，接口返回状态码断言都是成功（0）

 ***/

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import data.Redis;
import httputil.Assert;
import httputil.HttpUtil;
import httputil.PublicUtil;
import org.testng.annotations.Test;
import java.util.*;


import static httputil.PublicUtil.*;

/**
 * @Author: megan
 * @Date: 2018/11/19 下午3:32
 * @Description:
 **/
public class station_web {
    public String token ;
    public final static String skuid = "SELECT * from `user` WHERE openid = 'o7bgM5BIPmfV91oaM-m0ijum8Q-0'";
    @Test(enabled = true,priority = 1)
    @TestCase(id = "2000001", description = "登录短信发送-魔急便")
    public void dingtalk_send_message() throws Exception {
        String url = add + "/account-web/dingtalk/send/message?mobile=";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        String result = HttpUtil.sendGet(url,HEADER,"");
        System.out.println("响应参数： " + result);
        /*返回结果转换成json对象*/
        JSONObject resultJson = JSONObject.parseObject(result);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, status, "操作失败");
    }


    @Test(enabled = true,priority = 3)
    @TestCase(id = "2000002", description = "验证token是否过期-魔急便")
    public void station_check_token() throws Exception {
        String url = add + "/account-web/station/check/" + token;
        System.out.println(url);
        LinkedHashMap<String, Object> HEADER = new LinkedHashMap<String, Object>();
        String result = HttpUtil.sendGet(url, HEADER, "");
        System.out.println("响应参数： " + result);
        JSONObject resultJson = JSONObject.parseObject(result);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, status, "操作失败");
    }


    @Test(enabled = true,priority = 2)
    @TestCase(id = "2000003", description = "站点操作员登录-魔急便")
    public void station_login() throws Exception {
        String url = add + "/account-web/station/login";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("mobile", "15658019697");
        String code = Redis.getVaule("ffba0dc1aae7c1bb9f0edafbf1c279d28a4eb10538e6264705762683e7778861");
        bodyMap.put("code", code.substring(code.length()-4));
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url,HEADER ,bodyMap);
        System.out.println("响应参数： " + resultJson);

        /**获取站点程序token*/
        String data = PublicUtil.getResultJson(resultJson, "data");
        JSONObject data_all = JSONObject.parseObject(data);
        token = PublicUtil.getResultJson(data_all, "token");

        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality(status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, status, "操作失败");
    }


    @Test(enabled = true,priority = 3)
    @TestCase(id = "2000004", description = "判断站点是否有核销权限-魔急便")
    public void station_permission_stationId() throws Exception {
        String url = add + "/scm-web/station/permission/125" ;
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",token);
        String result = HttpUtil.sendGet(url,HEADER,"");
        System.out.println("响应参数： " + result);
        /*返回结果转换成json对象*/
        JSONObject resultJson = JSONObject.parseObject(result);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, status, "操作失败");
    }


    @Test(enabled = false,priority = 3)
    @TestCase(id = "2000005", description = "扫码支付-魔急便")
    public void scanpay_orderSn_code() throws Exception {
        String url = add + "/payment-web/scanpay/scanpay/181201139194499697/134604522522416333";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",token);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url,HEADER ,bodyMap);
        System.out.println("响应参数： " + resultJson);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality(status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, status, "操作失败");
    }


    @Test(enabled = true,priority = 3)
    @TestCase(id = "2000006", description = "扫码退款-魔急便")
    public void scanpay_refund_orderSn() throws Exception {
        String url = add + "/payment-web/scanpay/refund/181119102144049697";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",token);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("orderSn", "181119105535299697");
        bodyMap.put("refund", "其他");
        bodyMap.put("comment", "");
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url,HEADER ,bodyMap);
        System.out.println("响应参数： " + resultJson);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality("-3", actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, "-3", "操作失败");
    }


    @Test(enabled = true,priority = 3)
    @TestCase(id = "2000007", description = "查询订单-魔急便")
    public void scanpay_query_orderSn() throws Exception {
        String url = add + "/payment-web/scanpay/query/181114169916519697";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",token);
        String result = HttpUtil.sendGet(url,HEADER,"");
        System.out.println("响应参数： " + result);
        /*返回结果转换成json对象*/
        JSONObject resultJson = JSONObject.parseObject(result);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, status, "操作失败");
    }


    @Test(enabled = true,priority = 3)
    @TestCase(id = "2000008", description = "站点商城-魔急便")
    public void home_appId_sn() throws Exception {
        String url = add + "/store-web/station/shop/home/2/125";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",token);
        String result = HttpUtil.sendGet(url,HEADER,"");
        System.out.println("响应参数： " + result);
        /*返回结果转换成json对象*/
        JSONObject resultJson = JSONObject.parseObject(result);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, status, "操作失败");
    }


    @Test(enabled = true,priority = 3)
    @TestCase(id = "2000009", description = "站点下订单-魔急便")
    public void order_appId_sn() throws Exception {
        String url = add + "/store-web/station/order/2/125";
        String list = "{\"skuId\": 12,\"name\": \"熊本熊饮用水\",\"num\": 1,\"content\": \"\",\"price\": 1,\"perTotalPrice\": 1,\"showPrice\": \"0.01\",\"showPerTotalPrice\": \"0.01\"}";
        JSONArray Jsonlist = new JSONArray();
        Jsonlist.add(JSONObject.parseObject(list));
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",token);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("driverTel", 125);
        bodyMap.put("skuList",Jsonlist);
        bodyMap.put("payAmount", 1);
        bodyMap.put("tag", 6);
        bodyMap.put("type", 1);
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url,HEADER ,bodyMap);
        System.out.println("响应参数： " + resultJson);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality(status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, status, "操作失败");
    }



    @Test(enabled = true,priority = 3)
    @TestCase(id = "2000010", description = "订单列表-魔急便")
    public void list_appId_stationId() throws Exception {
        String url = add + "/store-web/station/order/list/2/125";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",token);
        String result = HttpUtil.sendGet(url,HEADER,"");
        System.out.println("响应参数： " + result);
        /*返回结果转换成json对象*/
        JSONObject resultJson = JSONObject.parseObject(result);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, status, "操作失败");
    }



    @Test(enabled = true,priority = 3)
    @TestCase(id = "2000011", description = "站点订单取消-魔急便")
    public void appId_orderSn_sn() throws Exception {
        String url = add + "/store-web/station/order/cancel/2/181119118780169697/125";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",token);
        String result = HttpUtil.sendGet(url,HEADER,"");
        System.out.println("响应参数： " + result);
        /*返回结果转换成json对象*/
        JSONObject resultJson = JSONObject.parseObject(result);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, status, "操作失败");
    }

}
