package com.chenyilei.netflix;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;

/**
 * {@link HystrixCommandAspect} 切面
 * {@link com.netflix.hystrix.HystrixCommandProperties}
 * 降级
 * @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
 *
 * 熔断 https://blog.csdn.net/wild46cat/article/details/80783078
 * commandProperties = {
 *                     @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
 *                     @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
 *                     @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
 *                     @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸(百分比)
 *             }
 *
 * @author qingshi
 * @email 705029004@qq.com
 * @date 2020/05/13 10:05 下午
 */
public class _3_Hystrix {
    public static void main(String[] args) {

    }
}
