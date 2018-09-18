package data;

import redis.clients.jedis.*;

import java.util.LinkedList;
import java.util.List;

public class Redis {
    private static ShardedJedisPool pool;
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(50);
        config.setMaxWaitMillis(3000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        // 集群
        JedisShardInfo jedisShardInfo1 = new JedisShardInfo("172.26.40.18", 6379);
        jedisShardInfo1.setPassword("redisPwd");
        List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
        list.add(jedisShardInfo1);
        pool = new ShardedJedisPool(config, list);
    }

    public static void main(String[] args) {
        ShardedJedis jedis = pool.getResource();
        String keys = "myname";
        //String vaule = jedis.set(keys, "lxr"); //redis下对应key值下写入vaule值
        String vaule = jedis.get(keys);         //redis下读取对应key值的vaule值
        System.out.println(vaule);
    }

    public static String getVaule(String keys) {
        ShardedJedis jedis = pool.getResource();
        String vaule = jedis.get(keys);
        return vaule;
    }
}