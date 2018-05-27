package com.qfang.examples.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-20
 * @since: 1.0
 */
@Component
public class PostFilter extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        LOG.info("------------ post filter ----------");

        /// 这里抛出异常会进入 error filter
//        int i = 5 / 0;

        return null;
    }
}
