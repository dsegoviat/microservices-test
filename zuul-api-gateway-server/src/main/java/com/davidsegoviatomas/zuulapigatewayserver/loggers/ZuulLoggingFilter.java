package com.davidsegoviatomas.zuulapigatewayserver.loggers;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() { // when should the filter be executed: before, after or error
        return "pre"; // pre: before, routing: during, post: after
    }

    @Override
    public int filterOrder() { // this is the priority set to the filter
        return 1;
    }

    @Override
    public boolean shouldFilter() { // boolean expressing if the filter is active or not
        return true;
    }

    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("request -> {}, request uri -> {}", request, request.getRequestURI());
        return null;
    }
}
