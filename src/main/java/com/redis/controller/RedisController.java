package com.redis.controller;

import com.redis.pojo.User;
import com.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/6/2.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/setStr")
    public String setStr(String key,String val){
        try {
            redisService.setStr(key,val);
            return "succcess";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping("/getStr")
    public String getStr(String key){
        try {
           return redisService.getStr(key);
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping("/setObj")
    public String setObj(String key){
        try {
            User obj = new User();
            obj.setId(1);
            obj.setName("zhangsan");
            redisService.setObj(key,obj);
            return "success";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    @RequestMapping("/getObj")
    public Object getObj(String key){
        return redisService.getObj(key);
    }

    @RequestMapping("/delObj")
    public String delObj(String key){
        try {
            redisService.delObj(key);
            return "success";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
