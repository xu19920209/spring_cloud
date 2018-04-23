package com.tuyue.util;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 徐慷慨
 * 途悦信息
 * Created by dell on 2018/3/5.
 */
public class JedisUtil {
    public static JedisPool pool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMaxWaitMillis(1000);
        JedisPool jedisPool=null;
        try{
             jedisPool = new JedisPool(jedisPoolConfig, "120.78.195.193", 6379,100);

        }catch (Exception e){
            e.getMessage();
        }
        return jedisPool;
    }
    public  static void close(redis.clients.jedis.Jedis jedis){
        if(jedis!=null){
            jedis.close();
        }
    }
    public static void main(String[] args) {
        //String s = Jedis.pool().getResource().setex("name",10,"sss");
        String s1 = JedisUtil.pool().getResource().get("name");
        JedisUtil.pool().close();
        System.out.println(s1);
    }
}
