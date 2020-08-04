package cn.jiyun.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
@RequestMapping("hello")
public class HelloController {
    @Autowired
    private DataSource dataSource;


    @GetMapping("show")
    public String index(){
        return "hello world!";
    }
}
