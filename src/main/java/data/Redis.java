package data;

import redis.clients.jedis.*;


import java.util.LinkedList;
import java.util.List;

public class Redis {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("172.16.137.20"); //测试环境
//        Jedis jedis = new Jedis("212.64.59.178");//开发环境
        jedis.auth("M3vj2eVa");
        jedis.select(2);
        String keys = "ffba0dc1aae7c1bb9f0edafbf1c279d28a4eb10538e6264705762683e7778861";
//        String vaule = jedis.set(keys, "o7bgM5BIPmfV91oaM-m0ijum8Q-0"); //redis下对应key值下写入vaule值
        String vaule = jedis.get(keys);//redis下读取对应key值的vaule值
//        System.out.println(vaule.substring(vaule.length()-4));  //redis下读取对应key值的vaule值的后四位
        System.out.println(vaule);
    }


    public static String getVaule(String keys) {
        Jedis jedis = new Jedis("172.16.137.20"); //测试环境
//        Jedis jedis = new Jedis("212.64.59.178");//开发环境
        jedis.auth("M3vj2eVa");
        jedis.select(2);
        String vaule = jedis.get(keys);
        return vaule;
    }

    public static String getSid() {
        Jedis jedis = new Jedis("172.16.137.20"); //测试环境
//        Jedis jedis = new Jedis("212.64.59.178"); //开发环境
        jedis.auth("M3vj2eVa");
        jedis.select(2);
        String sid = "sid123456";
        String vaule = jedis.set(sid, "kZbhgFVMxrJKcRIkVO5xtQ==#o7bgM5BIPmfV91oaM-m0ijum8Q-0"); //redis下对应key值下写入vaule值
        return sid;
    }



        /*指定库查询redis数据*/
//    public static void main(String[] args) {
//        Jedis jedis = new Jedis("212.64.59.178");
//        jedis.auth("M3vj2eVa");
//        jedis.select(2);
//        String keys = "67471b0dbf139558ce2be5ced5fc7cb2";
////        String vaule = jedis.set(keys, "o7bgM5BIPmfV91oaM-m0ijum8Q-0"); //redis下对应key值下写入vaule值
//        String vaule = jedis.get(keys);         //redis下读取对应key值的vaule值
//        System.out.println(vaule);
//    }

}
