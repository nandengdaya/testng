package httputil;

import com.alibaba.fastjson.JSONObject;
import data.DataDriver;
import data.MySQL;
import data.Redis;

//import com.sun.org.apache.bcel.internal.generic.NEW;

public class PublicUtil {
//  public final static String add="http://172.27.1.110:8080/miniuser-web";//开发环境
public final static String add="http://172.26.40.18:8888/miniuser-web";//测试环境

//    public final static String version="";        //应用版本号
//    public final static String Content = "application/x-www-form-urlencoded";
    public final static String mysql1 = "SELECT * from `user` WHERE openid = 'o7bgM5BIPmfV91oaM-m0ijum8Q-0'";
    public final static String sid="8411a18625124327b61058ac6793a06d";//用户的sid
    public final static String storeCode="S000183";  //商铺编码
    //    public final static String phone = "15658019697";  //手机号

    public final static String phone = MySQL.getColumnValues(mysql1,"phone");
    public final static String couponId = "11";//优惠券ID
    public final static String goodsCode = "20180808171055947";//商品ID
    public final static String code = "12345";//微信小程序登录传递参数:code
    public final static String phonecode = "12345";//验证码
    public final static String encryptedData = "";//
    public final static String iv = "";//
    public final static String orderCode = "201809041000442343";//订单code
    public final static String tip = "1";//tip标识，1:去结算，2:去支付
    public final static String address = "浙江省杭州市江干区东站枢纽西广场G层8号商铺";//店铺地址
    public final static String fixedTime = "";//预约时间
    public final static String takeType = "1";//预约类型
    public final static String userMemo = "";//客户备注
    public final static String payCode = "F201809040946221343";//支付编码
    public final static String refundCode = "TK20180904095859273";//订单编码
    public final static String categorycode = "20180808171000915";//商品分类
    public final static String x = "30.320046";//经度
    public final static String y = "120.13073";//维度
    public final static String flag  = "1";//flag表示(1代码增加，2代表减少)
    public final static String storename = "火车";//门店名字
    public final static String yzm = Redis.getVaule("CODE:"+phone);//从redis获取对应手机号的验证码
//   public final static Object num1 =DataDriver.getExcelData()[0][0];    //读取Excel一行数据


    //定义通用业务状态码
    public final static String status="1";                       //交互成功


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
    System.out.println(yzm);
   }
}
