package com.chenyilei.alibaba;

import com.alibaba.cloud.sentinel.SentinelWebAutoConfiguration;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.flow.controller.RateLimiterController;

/**
 * 注释
 *
 * {@link SentinelWebAutoConfiguration}
 * {@link SentinelResourceAspect}
 *
 * 流控
 *  默认流控处理 快速失败 {@link com.alibaba.csp.sentinel.slots.block.flow.controller.DefaultController}
 *  预热 {@link com.alibaba.csp.sentinel.slots.block.flow.controller.WarmUpController} 阀值为10,除以因子3,当前真正阀值是10/3 ,经过预热时间后恢复到10
 *  排队等待{@link RateLimiterController}
 *
 * 降级
 *  平均相应时间 RT 每秒5个请求以上才会触发
 *  异常比例  每秒5个请求以上才会触发
 *  异常数, 1分钟内异常数,窗口最好大于1分钟
 *
 * 热点限流 判断有没有传入 需要限流的字段,有的话计算阀值 {@link com.alibaba.csp.sentinel.slots.block.BlockException}
 *  {@link SentinelResource#blockHandler()} 处理的是控制的违规行为 !!!! ***
 *
 * 重要API
 *  SphU 定义资源
 *  Tracer 定义统计
 *  ContextUtil 定义了上下文
 *
 * Feign调用的资源名类似: GET:http://nacos-payment-provider/paymentSQL/{id}
 *
 *
 * @author qingshi
 * @email 705029004@qq.com
 * @date 2020/05/28 2:22 下午
 */
public class _1_Sentinel {
    public static void main(String[] args) {
    }
}
