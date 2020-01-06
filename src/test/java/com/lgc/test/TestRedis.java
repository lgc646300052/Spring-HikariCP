package com.lgc.test;

import redis.clients.jedis.Jedis;

public class TestRedis {
	public static void main(String[] args) {
		//连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        jedis.flushDB();
        //查看服务是否运行
//        System.out.println("服务正在运行: "+jedis.ping());
        jedis.set("k1", "v1");
        String[] lpushValues = new String[] {"p1", "p3", "p2"};
        jedis.lpush("kp", lpushValues);
        
        System.out.println(jedis.get("k1"));
        System.out.println(jedis.llen("kp"));
        System.out.println(jedis.lrange("kp", 0, jedis.llen("kp")));
	}

}
