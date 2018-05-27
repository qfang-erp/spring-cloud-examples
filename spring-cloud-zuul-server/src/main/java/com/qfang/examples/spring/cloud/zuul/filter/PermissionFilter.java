package com.qfang.examples.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限拦截器
 *
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-05-20
 * @since: 1.0
 */
@Component
public class PermissionFilter extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        LOG.info("------------ pre filter: order=2 ----------");

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        LOG.info("Permission filter, token: {}", token);
        if(StringUtils.isBlank(token)) {
            requestContext.setSendZuulResponse(false);  // 直接返回，不再执行下面的过滤器

            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("{\"result\": \"None permission\"}");
            requestContext.getResponse().setContentType("text/html;charset=utf-8");
        } else {
            // validate token in redis

        }
        return null;
    }
}
