package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootDevtoolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDevtoolsApplication.class, args);
    }

    @RequestMapping("/")
    String index() {
        //修改完代码后，按Ctrl+F9 重新编译,Springboot就会自动重启
        return "hello devtools";
    }

}
