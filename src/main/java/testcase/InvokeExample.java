package testcase;

import httputil.InvokeUtil;

import org.junit.Test;


public class InvokeExample {

    @Test
    public void test() throws Exception {
        //1.初始化环境

        //2.根据场景组合调用不同的测试用例
       InvokeUtil.invokeMethods(miniuser_web.class,"10002","10003");
       InvokeUtil.invokeMethods(miniuser_web.class,"10003","10004");
    }


}
