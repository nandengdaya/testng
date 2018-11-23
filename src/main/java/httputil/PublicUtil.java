package httputil;

import com.alibaba.fastjson.JSONObject;
import data.DataDriver;
import data.MySQL;
import data.Redis;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//import com.sun.org.apache.bcel.internal.generic.NEW;

public class PublicUtil {
    //  public final static String add="http://172.27.1.110:8080/miniuser-web";//开发环境
    /*定义couponId*/
    public final static String couponId = "123";
    public final static String storeCode = "f12345";
    /*通过数据库获取手机后*/
//    public final static String phone_mysql = "SELECT * from `user` WHERE openid = 'o7bgM5BIPmfV91oaM-m0ijum8Q-0'";
//    public final static String phone = MySQL.getColumnValues(phone_mysql,"phone");//手机号
    /*通过redis获取用户sid*/
//    public final static String sid=Redis.getSid();
    public final static String sid="123";
    /*从redis获取对应手机号的验证码*/
//    public final static String yzm = Redis.getVaule("CODE:"+phone);
    /*读取Excel一行数据*/
//   public final static Object num1 =DataDriver.getExcelData()[0][0];


    /*mobilego项目*/
    public final static String add="https://test-api.mobilemart.cn";//测试环境
//    public final static String add="https://dev-api.mobilemart.cn";//开发环境

    public final static String user_token = "5f96ada03cc99ed88c648289778ddf67";   //用户token
    public final static String admin_token = "e79141a9e4f9565b8de9554a1016f53f";  //站点管理员token
    public final static String shelfSn = "23604855";//货柜编号
    public final static String activitySn = "91028901789";//活动编号
    public final static String stationId = "125";//站点编号
    //定义通用业务状态码
    public final static String status="0";                       //交互成功

    /*
     *获取Json字符串中某个键的值
     * @resultObject  Json字符串
     * @code Json字符串Key值
     */
    public static String getResultJson(JSONObject json,String ret_code){
        String return_code=json.getString(ret_code);
        return  return_code;
    }



    public static void main(String[] args) {

    }

}