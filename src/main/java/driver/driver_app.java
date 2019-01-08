package driver;

import com.alibaba.fastjson.JSONObject;
import httputil.Assert;
import httputil.HttpUtil;
import httputil.PublicUtil;
import org.testng.annotations.Test;
import testcase.TestCase;

import java.util.Arrays;
import java.util.LinkedHashMap;

import static httputil.PublicUtil.add;
import static httputil.PublicUtil.status;


/**
 * @Author: megan
 * @Date: 2018/12/25 上午10:47
 * @Description:
 **/
public class driver_app {
    public String token ;
    public String openId ;
    public String order ;

    /***
     login和push
     ***/

    @Test(enabled = true,priority = 1)
    @TestCase(id = "3000001", description = "发短信(司机端通用)")
    public void validate_message_send() throws Exception {
        String url = add + "/driver-center-api/validate/message/send";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("tel", "15658019697");
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


    @Test(enabled = true,priority = 2)
    @TestCase(id = "3000002", description = "短信验证-业务操作")
    public void sms_check_type() throws Exception {
        String url = add + "/driver-center-api/validate/sms/check/1";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
//        bodyMap.put("districSn","" );
        bodyMap.put("tel", "15658019697");
        bodyMap.put("code", "6666");
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url,HEADER ,bodyMap);
        System.out.println("响应参数： " + resultJson);

        /**获取站点程序token和openId*/
        String data = PublicUtil.getResultJson(resultJson, "data");
        JSONObject data_all = JSONObject.parseObject(data);
        token = PublicUtil.getResultJson(data_all, "token");
        openId = PublicUtil.getResultJson(data_all, "openId");

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
    @TestCase(id = "3000003", description = "存储app信息")
    public void basic_message_setup() throws Exception {
        String url = add + "/driver-center-api/basic/message/setup";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("phoneModel", "HTC");
        bodyMap.put("systemVersion", "8.0.0");
        bodyMap.put("cid", "cid");
        bodyMap.put("pushId", "");
        bodyMap.put("phoneCategory", "1");
        bodyMap.put("ifVoice", "2");
        bodyMap.put("phoneType", "1");
        bodyMap.put("currentAppVersion", "2.0.1");
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
    @TestCase(id = "3000004", description = "检验是否注册")
    public void driver_regist_check() throws Exception {
        String url = add + "/driver-center-api/basic/driver/regist/check?tel=15658019697";
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
    @TestCase(id = "3000005", description = "推送记录处理")
    public void push_record() throws Exception {
        String url = add + "/driver-center-api/push/record";
        System.out.println(url);
        LinkedHashMap<String, Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("pushId", "20");
        bodyMap.put("ifRead", "1");
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPut(url, HEADER, bodyMap);
        System.out.println(resultJson);
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
    @TestCase(id = "3000006", description = "推送记录V2")
    public void push_record_list() throws Exception {
        String url = add + "/driver-center-api/push/record/list/v2?currentPage=1&pageSize=10&ifRead=";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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

    /***
      找油网合作业务
     ***/

    @Test(enabled = true,priority = 3)
    @TestCase(id = "3000007", description = "油品查询条件下拉列表")
    public void gas_stationQueryParams() throws Exception {
        String url = add + "/driver-center-api/gas/stationQueryParams";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000008", description = "计算订单优惠金额")
    public void gas_calculateDiscountAmount() throws Exception {
        String url = add + "/driver-center-api/gas/calculateDiscountAmount?oilId=3141&originAmount=20000&couponSeq=";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000009", description = "查询找油网加油站列表")
    public void gas_stationList() throws Exception {
        String url = add + "/driver-center-api/gas/stationList";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("longitude", "30.2910242086");
        bodyMap.put("latitude", "120.1142442226");
        bodyMap.put("oilType", "92#");
        bodyMap.put("sortType", "1");
        bodyMap.put("currentPage", "1");
        bodyMap.put("pageSize", "10");
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
    @TestCase(id = "3000010", description = "订单列表")
    public void gas_orderList() throws Exception {
        String url = add + "/driver-center-api/gas/orderList?payStatus=-1&currentPage=1&pageSize=10";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000011", description = "油站详情页")
    public void gas_stationInfo() throws Exception {
        String url = add + "/driver-center-api/gas/stationInfo?oilId=2500&stationId=101173&longitude=30.2910242086&latitude=120.1142442226";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000012", description = "订单生成")
    public void gas_order() throws Exception {
        String url = add + "/driver-center-api/gas/order";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("originAmount", "20000");
        bodyMap.put("oilId", "3141");
        bodyMap.put("stationId", "101173");
        bodyMap.put("oilGunId", "11");
        bodyMap.put("oilGunNo", "13");
        bodyMap.put("couponSeq", "");
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url,HEADER ,bodyMap);
        System.out.println("响应参数： " + resultJson);

        /**获取订单编号*/
        String data = PublicUtil.getResultJson(resultJson, "data");
        JSONObject data_all = JSONObject.parseObject(data);
        order = PublicUtil.getResultJson(data_all, "orderSn");
        System.out.println(order);
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
    @TestCase(id = "3000013", description = "加油订单信息")
    public void gas_orderInfo_orderSn() throws Exception {
        String url = add + "/driver-center-api/gas/orderInfo/181219194821569697";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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


    @Test(enabled = true,priority = 4)
    @TestCase(id = "3000014", description = "订单支付")
    public void gas_deposit_paySource() throws Exception {
        String url = add + "/driver-center-api/gas/deposit/6";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("payType", "2");
        bodyMap.put("orderSn", order);
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


    @Test(enabled = true,priority = 5)
    @TestCase(id = "3000015", description = "取消订单")
    public void order_cancle_orderSn() throws Exception {
        String url = add + "/driver-center-api/gas/order/cancle/"+order;
        System.out.println(url);
        LinkedHashMap<String, Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPut(url, HEADER, bodyMap);
        System.out.println(resultJson);
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
    @TestCase(id = "3000016", description = "订单优惠券列表")
    public void gas_coupons() throws Exception {
        String url = add + "/driver-center-api/gas/coupons";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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

    /***
     司机广告合作业务
     ***/

    /***


     提交展陈审核接口（首次/日常）
     /driver-center-api/ad/check/submit,需要绑定广告，当前未绑定广告，断言也是未绑定广告，断言值"-3"

     非特殊说明的，接口返回状态码断言都是成功（0）

     ***/

    @Test(enabled = true,priority = 3)
    @TestCase(id = "3000017", description = "提交展陈审核接口（首次/日常）")
    public void ad_check_submit() throws Exception {
        String url = add + "/driver-center-api/ad/check/submit";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("thirdCode","100046");
        bodyMap.put("imgList", Arrays.asList("https://img.mobilemart.cn/c6129e340b7316d6c69d17e5051927da"));
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
    @TestCase(id = "3000018", description = "查看相关司机审核记录列表接口")
    public void ad_check_list() throws Exception {
        String url = add + "/driver-center-api/ad/check/list";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000019", description = "查看此人有无最近一次审核状态接口（成功就静默通过提交，失败就弹框")
    public void ad_check_status() throws Exception {
        String url = add + "/driver-center-api/ad/check/status";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000020", description = "报名记录_报名安装")
    public void ad_register_register() throws Exception {
        String url = add + "/driver-center-api/ad/register/register";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000021", description = "广告开通页返回司机状态")
    public void ad_apply_driverStatus() throws Exception {
        String url = add + "/driver-center-api/ad/ad/apply/driverStatus";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000022", description = "返回司机皮套编码")
    public void ad_driverBind_thirdCode() throws Exception {
        String url = add + "/driver-center-api/ad/ad/driverBind/thirdCode";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000023", description = "返回司机广告收入")
    public void ad_driver_earning() throws Exception {
        String url = add + "/driver-center-api/ad/ad/driver/earning";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000024", description = "司机是否有过初次上传展陈审核接口")
    public void ad_check_has_init() throws Exception {
        String url = add + "/driver-center-api/ad/check/has/init";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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


    /***
     司机抽奖业务
     ***/

    @Test(enabled = true,priority = 3)
    @TestCase(id = "3000025", description = "周期内是否已抽奖")
    public void lottery_check_actSn() throws Exception {
        String url = add + "/driver-center-api/lottery/check/18121421402";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
//        bodyMap.put("actSn","18121421402");
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
    @TestCase(id = "3000026", description = "抽奖接口")
    public void lottery_lottery_actSn() throws Exception {
        String url = add + "/driver-center-api/lottery/lottery/18121421402";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("actSn","18121421402");
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url,HEADER ,bodyMap);
        System.out.println("响应参数： " + resultJson);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        if (Integer.parseInt(actual_ret_status) == -1)
        {
            String response = Assert.verify_Equality("-1", actual_ret_status);
            System.out.println(response + "------->原因是：" + actual_ret_msg);
            /*断言status的值与预期值是否一致*/
            Assert.assertEquals(actual_ret_status, "-1", "操作失败");
        }
        else{
            String response = Assert.verify_Equality(status, actual_ret_status);
            System.out.println(response + "------->原因是：" + actual_ret_msg);
            /*断言status的值与预期值是否一致*/
            Assert.assertEquals(actual_ret_status, status, "操作失败");
        }
    }


    @Test(enabled = true,priority = 3)
    @TestCase(id = "3000027", description = "抽奖次数")
    public void lottery_account_num() throws Exception {
        String url = add + "/driver-center-api/lottery/account/num?actSn=18121421402";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000028", description = "抽奖时的转盘信息接口")
    public void lottery_info() throws Exception {
        String url = add + "/driver-center-api/lottery/info?actSn=18121421402";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000029", description = "分享信息接口")
    public void share_content() throws Exception {
        String url = add + "/driver-center-api/share/content?actSn=18121421402";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000030", description = "周期分享增加抽奖次数接口")
    public void share_add_times() throws Exception {
        String url = add + "/driver-center-api/share/add/times";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("actSn","18121421402");
        bodyMap.put("shareUrl","http://h5.mobilemart.cn/test-activity/getMoreMoney.html?driverCode=3A98D67E6C81EFB43AE721479200D0CCB6F834F4F1637F74E71F8D59988DDA3CB229BA0CC948E860A8CFC751F4A6D848");
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url,HEADER ,bodyMap);
        System.out.println("响应参数： " + resultJson);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        if (Integer.parseInt(actual_ret_status) == -7)
        {
            String response = Assert.verify_Equality("-7", actual_ret_status);
            System.out.println(response + "------->原因是：" + actual_ret_msg);
            /*断言status的值与预期值是否一致*/
            Assert.assertEquals(actual_ret_status, "-7", "操作失败");
        }
        else{
            String response = Assert.verify_Equality(status, actual_ret_status);
            System.out.println(response + "------->原因是：" + actual_ret_msg);
            /*断言status的值与预期值是否一致*/
            Assert.assertEquals(actual_ret_status, status, "操作失败");
        }

    }


    @Test(enabled = true,priority = 3)
    @TestCase(id = "3000031", description = "抽奖页文字信息接口")
    public void lottery_view() throws Exception {
        String url = add + "/driver-center-api/lottery/view?actSn=18121421402";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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


    /***
     basic业务
     ***/


    @Test(enabled = true,priority = 3)
    @TestCase(id = "3000032", description = "获取司机状态权限信息")
    public void basic_driver_info() throws Exception {
        String url = add + "/driver-center-api/basic/driver/info";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000033", description = "语音接口开关控制")
    public void basic_switch_ifVoice() throws Exception {
        String url = add + "/driver-center-api/basic/switch/1";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
//        bodyMap.put("ifVoice","1");
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
    @TestCase(id = "3000034", description = "验证token")
    public void basic_token_check() throws Exception {
        String url = add + "/driver-center-api/basic//token/check";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000035", description = "版本控制-查看")
    public void basic_version_phoneType() throws Exception {
        String url = add + "/driver-center-api/basic/version/1";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
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
    @TestCase(id = "3000036", description = "版本控制-添加")
    public void basic_version() throws Exception {
        String url = add + "/driver-center-api/basic/version";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("versionCode","2.1");
        bodyMap.put("buildNum","2");
        bodyMap.put("lowestUpdateNum","1");
        bodyMap.put("ifPop","");
        bodyMap.put("phoneType","1");
        bodyMap.put("updateMessage","1");
        bodyMap.put("url","1");
        bodyMap.put("message_desc","1");
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


    @Test(enabled = false,priority = 3)
    @TestCase(id = "3000037", description = "版本控制-更新")
    public void basic_version_put() throws Exception {
        String url = add + "/driver-center-api/basic/version";
        System.out.println(url);
        LinkedHashMap<String, Object> HEADER = new LinkedHashMap<String, Object>();
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("versionCode","2.1");
        bodyMap.put("id","1");
        bodyMap.put("buildNum","2");
        bodyMap.put("lowestUpdateNum","1");
        bodyMap.put("ifPop","");
        bodyMap.put("phoneType","1");
        bodyMap.put("updateMessage","1");
        bodyMap.put("url","1");
        bodyMap.put("message_desc","1");
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPut(url, HEADER, bodyMap);
        System.out.println(resultJson);
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


    @Test(enabled = false,priority = 6)
    @TestCase(id = "3000038", description = "清除某token")
    public void login_token_clear() throws Exception {
        String url = add + "/driver-center-api/login/token/clear";
        System.out.println(url);
        LinkedHashMap<String, Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("X-AuthToken-With",token);
        HEADER.put("openId",openId);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPut(url, HEADER, bodyMap);
        System.out.println(resultJson);
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

}
