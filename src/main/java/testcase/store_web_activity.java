package testcase;
/***

 抽奖接口
 /store-web/activity/v1/ms/lucky_draw返回的状态码断言的值是"103"
 因为抽奖次数会使用完，所以断言的是使用完成的状态码（103）

 助力别人接口
 /store-web/activity/team/help返回的状态码断言的值是"-5"
 因为每个用户只能助力同一个用户一次，所以断言的是用户已经助力过的状态码（-5）

 发起助力接口
 /store-web/activity/team/organize返回的状态码断言的值是"-7"
 因为每个用户只能发起一次助力，所以断言的是用户已经发起过助力的状态（-7）

 非特殊说明的，接口返回状态码断言都是成功（0）

 ***/


import com.alibaba.fastjson.JSONObject;
import httputil.Assert;
import httputil.HttpUtil;
import httputil.Log;
import httputil.PublicUtil;
import org.testng.annotations.Test;


import java.util.LinkedHashMap;

import static httputil.PublicUtil.*;

public class store_web_activity  {
    @Test(enabled = true)
    @TestCase(id = "1000001", description = "活动主页--玛仕活动")
    public void main_activitySn_status() throws Exception {
        String url = add + "/store-web/activity/v1/ms/main/" + activitySn + "/" + status;
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",PublicUtil.user_token);
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


    @Test(enabled = true)
    @TestCase(id = "1000002", description = "活动抽奖次数--玛仕活动")
    public void lottery_num_activitySn() throws Exception {
        String url = add + "/store-web/activity/v1/ms/lottery_num/" + activitySn;
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",PublicUtil.user_token);
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


    @Test(enabled = true)
    @TestCase(id = "1000003", description = "抽奖接口---玛仕活动")
    public void ms_lucky_draw() throws Exception {
        String url = add + "/store-web/activity/v1/ms/lucky_draw";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",PublicUtil.user_token);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("shelfSn", shelfSn);
        bodyMap.put("activitySn", activitySn);
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url,HEADER ,bodyMap);
        System.out.println("响应参数： " + resultJson);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality("103", actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, "103", "操作失败");
    }


    @Test(enabled = true)
    @TestCase(id = "1000004", description = "地址-新建和编辑收货地址")
    public void address_info_add() throws Exception {
        String url = add + "/store-web/user/address/info";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",PublicUtil.user_token);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("id", "110");
        bodyMap.put("name", "杨林");
        bodyMap.put("mobile", "15658019697");
        bodyMap.put("province", "");
        bodyMap.put("city", "");
        bodyMap.put("county", "");
        bodyMap.put("town", "");
        bodyMap.put("address", "");
        bodyMap.put("remark", "");
        bodyMap.put("status", "");
        bodyMap.put("addTime", "");
        bodyMap.put("updateTime", "");
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url, HEADER,bodyMap);
        System.out.println("响应参数： " + resultJson);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, status, "操作失败");
    }


    @Test(enabled = true)
    @TestCase(id = "1000005", description = "地址-收货地址的回显")
    public void address_info_display() throws Exception {
        String url = add + "/store-web/user/address/info/110";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",PublicUtil.user_token);
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


    @Test(enabled = true)
    @TestCase(id = "1000006", description = "我的中奖记录列表---玛氏活动")
    public void prize_record_actSn() throws Exception {
        String url = add + "/store-web/user/prize/record/"+activitySn;
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",PublicUtil.user_token);
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


    @Test(enabled = true)
    @TestCase(id = "1000007", description = "更新我的中奖记录---玛氏活动")
    public void user_prize_logistics() throws Exception {
        String url = add + "/store-web/user/prize/logistics";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",PublicUtil.user_token);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("id", "");
        bodyMap.put("activitySn", "");
        bodyMap.put("appUserId", "");
        bodyMap.put("prizeId", "");
        bodyMap.put("expressNumber", "");
        bodyMap.put("expressName", "");
        bodyMap.put("status", "");
        bodyMap.put("isDeleted", "");
        bodyMap.put("addTime", "");
        bodyMap.put("updateTime", "");
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url, HEADER,bodyMap);
        System.out.println("响应参数： " + resultJson);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, status, "操作失败");
    }


    @Test(enabled = true)
    @TestCase(id = "1000008", description = "收到邀请---玛氏活动")
    public void assistance_actSn_teamId() throws Exception {
        String url = add + "/store-web/user/assistance/"+activitySn+"/374";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",PublicUtil.user_token);
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


    @Test(enabled = true)
    @TestCase(id = "1000009", description = "获取更多参赛队员----玛仕活动")
    public void team_v1_list() throws Exception {
        String url = add + "/store-web/activity/team/v1/list";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",PublicUtil.user_token);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("teamId", "374");
//        bodyMap.put("currentPage", "1");
//        bodyMap.put("pageSize", "10");
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url, HEADER,bodyMap);
        System.out.println("响应参数： " + resultJson);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, status, "操作失败");
    }


    @Test(enabled = true)
    @TestCase(id = "1000010", description = "助力别人--玛氏活动")
    public void activity_team_help() throws Exception {
        String url = add + "/store-web/activity/team/help";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",PublicUtil.user_token);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("teamId", "374");
        bodyMap.put("activitySn", activitySn);
        bodyMap.put("appUserId", "");
        bodyMap.put("isLeader", "");
        bodyMap.put("headImg", "");
        bodyMap.put("isLuck", "");
        bodyMap.put("addTime", "");
        bodyMap.put("updateTime", "");
        bodyMap.put("isDeleted", "");
        bodyMap.put("leaderId", "175221");
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url, HEADER,bodyMap);
        System.out.println("响应参数： " + resultJson);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality("-5", actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, "-5", "操作失败");
    }


    @Test(enabled = true)
    @TestCase(id = "1000011", description = "发起助力---玛氏活动")
    public void activity_team_organize() throws Exception {
        String url = add + "/store-web/activity/team/organize";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",PublicUtil.user_token);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("activitySn", activitySn);
        bodyMap.put("appUserId","175221");
        bodyMap.put("num", "");
        bodyMap.put("type", "1");
        bodyMap.put("status", "");
        bodyMap.put("headImg", "");
        bodyMap.put("addTime", "");
        bodyMap.put("updateTime", "");
        bodyMap.put("isDeleted", "");
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url, HEADER,bodyMap);
        System.out.println("响应参数： " + resultJson);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality("-7", actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, "-7", "操作失败");
    }


    @Test(enabled = true)
    @TestCase(id = "1000012", description = "动态生成海报")
    public void user_upload() throws Exception {
        String url = add + "/store-web/user/upload";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",PublicUtil.user_token);
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("content","测试");
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.sendPost(url, HEADER,bodyMap);
        System.out.println("响应参数： " + resultJson);
        /*取Json字符串里某Key值*/
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "error_code");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "err_msg");
        /*验证预期值 和实际返回值是否一致*/
        String response = Assert.verify_Equality(PublicUtil.status, actual_ret_status);
        System.out.println(response + "------->原因是：" + actual_ret_msg);
        /*断言status的值与预期值是否一致*/
        Assert.assertEquals(actual_ret_status, status, "操作失败");
    }


    @Test(enabled = false)
    @TestCase(id = "1000020", description = "订单列表")
    public void order_list() throws Exception {
        String url = add + "/station-web/station/order/list/2/125";
        System.out.println(url);
        LinkedHashMap<String,Object> HEADER = new LinkedHashMap<String, Object>();
        HEADER.put("token",PublicUtil.admin_token);
        String result = HttpUtil.sendGet(url,HEADER,"currentPage=2");
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