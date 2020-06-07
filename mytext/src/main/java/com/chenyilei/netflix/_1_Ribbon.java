package com.chenyilei.netflix;

import org.springframework.cloud.client.loadbalancer.LoadBalancerAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;

/**
 * 注释
 * 一种负载均衡的实现
 * 依赖于 {@link org.springframework.web.client.RestTemplate}
 * {@link org.springframework.cloud.client.loadbalancer.LoadBalanced}
 *
 * {@link RibbonClientConfiguration} 提供了一个具体的iloadbalance
 * {@link org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration} 提供了 负载均衡的client,去选择一个iloadbalance
 * {@link LoadBalancerAutoConfiguration} 找到自己标注LoadBalanced注解的restTemplate,并进行代理
 *
 *
 * @author qingshi
 * @email 705029004@qq.com
 * @date 2020/05/13 9:49 下午
 */
public class _1_Ribbon {
    public static void main(String[] args) {

    }
}
