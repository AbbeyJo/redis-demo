package com.redis.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/6/2.
 */
@Controller
public class PageController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/next")
    @ResponseBody
    public String next(){
        System.out.print(123);
        return "next";
    }








}
