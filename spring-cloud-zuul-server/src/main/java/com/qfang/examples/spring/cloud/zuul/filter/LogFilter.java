package com.qfang.examples.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-20
 * @since: 1.0
 */
@Component
public class LogFilter extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public String filterType() {
        return "pre";
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
        RequestContext rq = RequestContext.getCurrentContext();
        HttpServletRequest request = rq.getRequest();
        LOG.info("------------ pre filter: order=1 ----------");
        LOG.info("request info, method: {}, url: {}", request.getMethod(), request.getRequestURL().toString());
        return null;
    }
}
