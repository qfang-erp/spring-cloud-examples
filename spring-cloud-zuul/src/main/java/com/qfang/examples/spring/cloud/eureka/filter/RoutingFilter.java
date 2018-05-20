package com.qfang.examples.spring.cloud.eureka.filter;

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
public class RoutingFilter extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        LOG.info("------------ routing filter ----------");

        return null;
    }
}
