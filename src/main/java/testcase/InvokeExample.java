package testcase;

import httputil.InvokeUtil;

import org.junit.Test;


public class InvokeExample {

    @Test
    public void Login_case() throws Exception {  //登录用例
        //1.初始化环境
        //2.根据场景组合调用不同的测试用例
      InvokeUtil.invokeMethods(store_web_activity.class,"1000001","1000001");
    }

    @Test
    public void Shopping_case() throws Exception {   //购物车选择商品

        InvokeUtil.invokeMethods(store_web_activity.class,"","");

    }

}
