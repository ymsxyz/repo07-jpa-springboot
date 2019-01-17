package cn.ymsxyz.quick.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(value = "/quick",method = RequestMethod.GET)
    public String testGet(){
        return "get请求1";
    }
    @RequestMapping(value = "/quick",method = RequestMethod.POST)
    public String testPost(){
        return "post请求1";
    }
}
