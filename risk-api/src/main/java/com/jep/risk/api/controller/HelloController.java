package com.jep.risk.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/8 下午3:40
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String testHello() {
        return "this junit5 MockMvc Test";
    }
}
