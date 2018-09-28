package testcase;

import com.alibaba.fastjson.JSONObject;
import data.Redis;
import httputil.Assert;
import httputil.HTTPClientUtil;
import httputil.HttpUtil;
import httputil.PublicUtil;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.util.LinkedHashMap;

import static httputil.PublicUtil.*;

public class miniuser_web {
    @Test(enabled = false)
    @TestCase(id = "100001", description = "计算选中的优惠券的优惠金额")
    public void coupon_calc() throws Exception {
        String url = add + "/coupon/calc";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("couponId", couponId);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//        验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100002", description = "根据sid查询优惠券表中的所有信息")
    public void coupon_queryAll() throws Exception {
        String url = add + "/coupon/queryAll";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", "123");
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100003", description = "根据用户的sid和优惠券的状态来查询优惠券")
    public void coupon_queryByStatus() throws Exception {
        String url = add + "/coupon/queryByStatus";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("status", "1");
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100004", description = "根据用户的sid和优惠券的状态来查询优惠券")
    public void coupon_suitable() throws Exception {
        String url = add + "/coupon/suitable";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", PublicUtil.sid);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100005", description = "根据id修改优惠券的状态")
    public void coupon_updateStatusById() throws Exception {
        String url = add + "/coupon/updateStatusById";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", PublicUtil.sid);
        bodyMap.put("status", "1");
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/

    }

    @Test(enabled = true)
    @TestCase(id = "100006", description = "根据id修改优惠券的状态")
    public void goods_queryByStoreCode() throws Exception {
        String url = add + "/goods/queryByStoreCode";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("storeCode", storeCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100007", description = "根据sid查询优惠券表中的所有信息")
    public void goods_queryDetailByGoodsCode() throws Exception {
        String url = add + "/goods/queryDetailByGoodsCode";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("storeCode", storeCode);
        bodyMap.put("goodsCode", goodsCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100008", description = "微信小程序登录传递参数:code")
    public void miniuser_loginByCode() throws Exception {
        String url = add + "/miniuser/loginByCode";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("code", code);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false,dependsOnMethods = { "app_yzm" }) //执行该条测试用例前要先执行app_yzm
    @TestCase(id = "100009", description = "微信小程序手机号码登录")
    public void miniuser_loginByPhone() throws Exception {
        String url = add + "/miniuser/loginByPhone";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        Object yzm = Redis.getVaule("CODE:"+phone); //从Redis读取验证码
        bodyMap.put("phone", phone);
        bodyMap.put("sid", sid);
        bodyMap.put("code", yzm);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100010", description = "根据sid判断是否登录过")
    public void miniuser_loginBySid() throws Exception {
        String url = add + "/miniuser/loginBySid";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100011", description = "微信小程序登录")
    public void miniuser_wxDecodeUserInfo() throws Exception {
        String url = add + "/miniuser/wxDecodeUserInfo";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("encryptedData", encryptedData);
        bodyMap.put("iv", iv);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100012", description = "根据sid查询‘我的’页面的信息")
    public void my_myInfo() throws Exception {
        String url = add + "/my/myInfo";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100013", description = "根据sid查询‘我的积分’页面的信息")
    public void my_myIntegral() throws Exception {
        String url = add + "/my/myIntegral";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100014", description = "微信支付结果通知")
    public void notify_wxpay() throws Exception {
        String url = add + "/notify/wxpay";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100015", description = "微信退款结果通知")
    public void notify_wxrefund() throws Exception {
        String url = add + "/notify/wxrefund";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100016", description = "订单中心-根据二维码核销订单")
    public void order_all() throws Exception {
        String url = add + "/order/all";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100017", description = "订单中心-取消订单")
    public void order_cancel() throws Exception {
        String url = add + "/order/cancel";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("orderCode", orderCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false,dependsOnMethods = { "shopcar_edit" })
    @TestCase(id = "100018", description = "校验购物车中的商品是否售空")
    public void order_checkShopCar() throws Exception {
        String url = add + "/order/checkShopCar";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("tip", tip);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100019", description = "订单中心-根据二维码核销订单")
    public void order_closure() throws Exception {
        String url = add + "/order/closure";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("orderCode", orderCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100020", description = "订单中心-删除订单")
    public void order_delete() throws Exception {
        String url = add + "/order/delete";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("orderCode", orderCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100021", description = "订单中心-订单详情")
    public void order_getorder() throws Exception {
        String url = add + "/order/getorder";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("orderCode", orderCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100022", description = "订单中心-订单详情")
    public void order_getordergoods() throws Exception {
        String url = add + "/order/getordergoods";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("orderCode", orderCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100023", description = "订单详情-无优惠付款")
    public void order_pay() throws Exception {
        String url = add + "/order/pay";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("address", address);
        bodyMap.put("fixedTime", fixedTime);
        bodyMap.put("takeType", takeType);
        bodyMap.put("userMemo", userMemo);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100024", description = "订单详情-使用优惠券付款")
    public void order_payWithCoupon() throws Exception {
        String url = add + "/order/payWithCoupon";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("couponId", couponId);
        bodyMap.put("address", address);
        bodyMap.put("fixedTime", fixedTime);
        bodyMap.put("takeType", takeType);
        bodyMap.put("userMemo", userMemo);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100025", description = "订单中心-再来一单")
    public void order_rebuy() throws Exception {
        String url = add + "/order/rebuy";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("orderCode", orderCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100026", description = "订单中心-支付待支付订单")
    public void order_repay() throws Exception {
        String url = add + "/order/repay";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("orderCode", repayorderCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100027", description = "订单中心-出示订单二维码")
    public void order_showqr() throws Exception {
        String url = add + "/order/showqr";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("orderCode", orderCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100028", description = "获取门店优惠")
    public void order_storepromotion() throws Exception {
        String url = add + "/order/storepromotion";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100029", description = "根据sid查询‘我的积分’页面的信息")
    public void pay_cancel() throws Exception {
        String url = add + "/pay/cancel";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("orderCode", orderCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100030", description = "检查支付结果")
    public void pay_checkstate() throws Exception {
        String url = add + "/pay/checkstate";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("payCode", payCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100031", description = "检测退款单状态")
    public void refund_checkstate() throws Exception {
        String url = add + "/refund/checkstate";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("refundCode", refundCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100032", description = "创建退款单")
    public void refund_create() throws Exception {
        String url = add + "/refund/create";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("payCode", payCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100033", description = "点击分类")
    public void report_clickcategory() throws Exception {
        String url = add + "/report/clickcategory";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("code", categorycode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100034", description = "点单小程序的退出时间")
    public void report_close() throws Exception {
        String url = add + "/report/close";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100035", description = "进入商品详情页的时间点")
    public void report_ingoods() throws Exception {
        String url = add + "/report/ingoods";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("code", goodsCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100036", description = "点单小程序的用户登录时间点")
    public void report_login() throws Exception {
        String url = add + "/report/login";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100037", description = "点单小程序的用户退出时间点")
    public void report_loginout() throws Exception {
        String url = add + "/report/loginout";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100038", description = "点单小程序的打开时间")
    public void report_open() throws Exception {
        String url = add + "/report/open";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100039", description = "退出商品详情页的时间点")
    public void report_outgoods() throws Exception {
        String url = add + "/report/outgoods";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("code", goodsCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100040", description = "用户定位信息统计")
    public void report_statisticsLocation() throws Exception {
        String url = add + "/report/statisticsLocation";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("x", x);
        bodyMap.put("y", y);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100041", description = "获取购物车中所有商品信息")
    public void shopcar_all() throws Exception {
        String url = add + "/shopcar/all";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("storeCode", storeCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100042", description = "商品加入购物车")
    public void shopcar_edit() throws Exception {
        String url = add + "/shopcar/edit";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("storeCode", storeCode);
        bodyMap.put("goodsCode", goodsCode);
        bodyMap.put("flag", flag);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100043", description = "清空购物车")
    public void shopcar_removeall() throws Exception {
        String url = add + "/shopcar/removeall";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100044", description = "查询收藏的店")
    public void store_collection() throws Exception {
        String url = add + "/store/collection";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("x", x);
        bodyMap.put("y", y);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100045", description = "收藏某店")
    public void store_collection_add() throws Exception {
        String url = add + "/store/collection/add";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("storeCode", storeCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100046", description = "移除收藏的某店")
    public void store_collection_delete() throws Exception {
        String url = add + "/store/collection/delete";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("storeCode", storeCode);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100047", description = "查询距离5公里之内的店")
    public void store_queryAll() throws Exception {
        String url = add + "/store/queryAll";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("x", x);
        bodyMap.put("y", y);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100048", description = "模糊查询搜索门店信息")
    public void store_search() throws Exception {
        String url = add + "/store/search";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        bodyMap.put("storeName",storename);
        bodyMap.put("x", x);
        bodyMap.put("y", y);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = false)
    @TestCase(id = "100049", description = "根据经纬度查询周围的五家门店")
    public void store_searchAround5() throws Exception {
        String url = add + "/store/searchAround5";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("x", x);
        bodyMap.put("y", y);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled = true)
    @TestCase(id = "100050", description = "查询用户的积分")
    public void userScore_myIntegral() throws Exception {
        String url = add + "/userScore/myIntegral";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", sid);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }

    @Test(enabled =false)
    @TestCase(id = "100051", description = "验证码接口")
    public void app_yzm() throws Exception {
        String url = add + "/app/yzm";
        System.out.println(url);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("phone", phone);
        System.out.println("请求参数： " + bodyMap);
        String result = HTTPClientUtil.doPost(url, bodyMap);
        System.out.println("响应参数： " + result);
//       返回结果转换成json对象
        JSONObject resultJson = JSONObject.parseObject(result);
//        取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//       验证预期值 和实际返回值是否一致
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        Assert.assertEquals(actual_ret_status,status,"操作失败");/*断言status的值与预期值是否一致*/
    }
}
