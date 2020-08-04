package cn.jiyun.ssm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello2")
public class HelloController2 {
    @GetMapping("show")
    public String index(){
        return "hello world";
    }
}
