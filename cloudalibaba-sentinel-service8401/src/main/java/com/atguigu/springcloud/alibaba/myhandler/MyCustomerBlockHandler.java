package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;

/**
 * 注释
 *
 * @author qingshi
 * @email 705029004@qq.com
 * @date 2020/06/18 11:30 上午
 */
@Slf4j
public class MyCustomerBlockHandler {
    public static CommonResult ex1(BlockException throwable) {
        return new CommonResult(999, "自定义返回");
    }
}
