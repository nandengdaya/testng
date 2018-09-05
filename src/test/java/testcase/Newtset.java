package testcase;

import com.alibaba.fastjson.JSONObject;
import httputil.Assert;
import httputil.HttpUtil;
import httputil.PublicUtil;
import org.testng.annotations.Test;
import java.util.LinkedHashMap;

public class Newtset {
    //自动化测试用例_获取购物车中所有商品信息
    @Test(enabled = true)
    @TestCase(id = "100001", description = "获取购物车中所有商品信息")
    public void shopcar_all() throws Exception {
        String url = PublicUtil.add + "/shopcar/all";
        LinkedHashMap<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("sid", PublicUtil.sid);
        bodyMap.put("storeCode", PublicUtil.storeCode);
        System.out.println("请求参数： " + bodyMap);
        JSONObject resultJson = HttpUtil.postRequest(url, bodyMap);
        System.out.println("响应参数： " + resultJson);
//      取Json字符串里某Key值
        String actual_ret_status = PublicUtil.getResultJson(resultJson, "status");
        String actual_ret_msg = PublicUtil.getResultJson(resultJson, "msg");
//        验证预期值 和实际返回值是否一致
        String result = Assert.verify_Equality(PublicUtil.status,actual_ret_status);
        System.out.println(result + "------->原因是：" + actual_ret_msg);
    }
}
