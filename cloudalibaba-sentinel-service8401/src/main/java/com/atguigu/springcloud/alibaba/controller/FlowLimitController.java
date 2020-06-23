package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @auther zzyy
 * @create 2020-02-24 16:26
 */
@RestController
@Slf4j
public class FlowLimitController {

    @Autowired
    private Optional<String> a;

    @GetMapping("/testA")
    public String testA() {
        System.err.println(a.get());
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "------testB";
    }


    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");

//        log.info("testD 异常比例");
//        int age = 10 / 0;
        return "------testD";
    }

    @GetMapping("/testE")
    @SentinelResource(fallback = "fallback")
    public String testE() {
        log.info("testE 测试异常数");
        int age = 10 / 0;
        return "------testE 测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
//        int age = 10/0;
        return "------testHotKey";
    }

    public String fallback(Throwable exception) {
        System.err.println(exception);
        return "------deal_testHotKey,o(╥﹏╥)o";  //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
    }

    public String deal_testHotKey(String p1, String p2, Throwable exception) {
        System.err.println(exception);
        return "------deal_testHotKey,o(╥﹏╥)o" + p1 + "==" + p2;  //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
    }

}
