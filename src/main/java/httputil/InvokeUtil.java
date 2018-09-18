package httputil;

import testcase.TestCase;

import java.lang.reflect.Method;


public class InvokeUtil {

    public static void invokeMethods(Class clazz,String... strs) throws Exception {
        Object obj = clazz.newInstance();
        for (String str:strs){
            invokeMethod(obj, str);
            Thread.sleep(2000);
        }
    }

    public static void invokeMethod(Object obj , String testCaseId) throws Exception {
        for (Method m : obj.getClass().getDeclaredMethods()) {
            TestCase tc = m.getAnnotation(TestCase.class);
            if(tc==null||!tc.id().equals(testCaseId)){
                continue;
            }
            try{
                m.invoke(obj);
            }catch (Exception e){
                System.out.println("["+tc.description()+"]执行失败,原因"+e.getMessage());
                throw e;
            }
            System.out.println("["+tc.description()+"]执行成功");
            return ;
        }
        System.out.println("测试用例["+testCaseId+"]未找到");
    }
}
