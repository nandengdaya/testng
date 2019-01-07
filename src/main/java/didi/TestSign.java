package didi;


import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.*;

/**
 * @Author: megan
 * @Date: 2019/1/7 上午10:50
 * @Description:
 **/
public class TestSign {



    public static void main(String[] args) {
        Map map = new HashMap();
//        uid=14750802576&role=6&clientId=110
        map.put("uid",14750802576L);
        map.put("role",6);
        map.put("clientId",110);

        Long time = System.currentTimeMillis();
        System.out.println(time);



        BasicNameValuePair d = new BasicNameValuePair("skuId",String.valueOf(317));
        BasicNameValuePair a = new BasicNameValuePair("time",String.valueOf(time));
        List<BasicNameValuePair> params2 = new ArrayList<>(16);

        params2.add(a);
        params2.add(d);

        String signStr = createSign(params2,"Dd#4r8coupon?_7rfG@");
        System.out.println(signStr);
        params2.add(new BasicNameValuePair("sign",signStr));

    }





    public static String createSign(List<BasicNameValuePair> params, String secretKey) {
        String sign=null;
        Collections.sort(params, new Comparator<BasicNameValuePair>() {
            public int compare(BasicNameValuePair lhs, BasicNameValuePair rhs) {
                return lhs.getName().compareTo(rhs.getName());
            }
        });
        StringBuilder queryString = new StringBuilder(30);
        for (BasicNameValuePair param : params) {
            if (StringUtils.isEmpty(param.getValue().toString())) {
                continue;
            }
            queryString.append(param.getName()+"="+param.getValue()+"&");
        }
        queryString.append("key=").append(DigestUtils.sha256Hex(secretKey));
        sign= StringUtils.upperCase(DigestUtils.sha256Hex(queryString.toString()));
        return sign;
    }

    }
