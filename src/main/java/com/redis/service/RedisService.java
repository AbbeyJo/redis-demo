package com.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/6/2.
 *
 */
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String,String> valueOpStr;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valueOpObject;

    /**
     * 获取key的 值
     */
    public String getStr(String key){
        return valueOpStr.get(key);
    }

    /**
     * 设置string型的 redis缓存
     */
    public void setStr(String key,String val){
        valueOpStr.set(key,val);
    }

    /**
     * 删除指定的key
     * @param key
     */
    public void del(String key){
        stringRedisTemplate.delete(key);
    }

    /**
     * 获得指定key的value值
     * @param key
     * @return
     */
    public Object getObj(Object key){
        return valueOpObject.get(key);
    }

    /**
     *设置object型的redis缓存
     * @param key
     * @param val
     */
    public void setObj(Object key,Object val){
        valueOpObject.set(key,val);
    }

    public void delObj(Object key){
        redisTemplate.delete(key);
    }
}
