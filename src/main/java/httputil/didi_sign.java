package httputil;


import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @Author: megan
 * @Date: 2019/1/7 上午10:32
 * @Description:
 **/
public class didi_sign {

    public static String createSignDev(List<BasicNameValuePair> params) {

        final String SECRET = "Dd#4r8coupon?_7rfG@";
        String sign=null;
        Collections.sort(params, new Comparator<BasicNameValuePair>() {
            @Override
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
        queryString.append("key=").append(DigestUtils.sha256Hex(SECRET));
        sign= StringUtils.upperCase(DigestUtils.sha256Hex(queryString.toString()));
        return sign;
    }

    public static String createSignOnline(List<BasicNameValuePair> params) {

        final String SECRET = "WIfj@b1Spd3)T2@BDkF";
        String sign=null;
        Collections.sort(params, new Comparator<BasicNameValuePair>() {
            @Override
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
        queryString.append("key=").append(DigestUtils.sha256Hex(SECRET));
        sign= StringUtils.upperCase(DigestUtils.sha256Hex(queryString.toString()));
        return sign;
    }

}
