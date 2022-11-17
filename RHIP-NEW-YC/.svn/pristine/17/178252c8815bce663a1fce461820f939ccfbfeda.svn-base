package com.founder.rhip.portal.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author BaGen
 * @Description:
 * @Date Created in 10:50 2017/7/19.
 */

public class IframeFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        /**
         * DENY：浏览器拒绝当前页面加载任何Frame页面
         * SAMEORIGIN：frame页面的地址只能为同源域名下的页面
         * ALLOW-FROM：origin为允许frame加载的页面地址"
         */
//        httpServletResponse.addHeader("x-frame-options","ALLOW-FROM www.yczhyl.gov.cn");
        httpServletResponse.addHeader("x-frame-options","ALLOW-FROM http://www.yczhyl.gov.cn/");
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
