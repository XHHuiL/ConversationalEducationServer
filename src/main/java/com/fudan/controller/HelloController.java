package com.fudan.controller;


import com.fudan.response.HelloResponse;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    private final AtomicLong counter = new AtomicLong();

    // @RequestMapping也可以修饰class，更好地支持Restful的服务
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody
    HelloResponse hello(@RequestParam(value = "name", defaultValue = "World") String name){
        return new HelloResponse(counter.incrementAndGet(), "Hello, " + name + "!");
    }

}
