package com.uway.springboot.boot.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created by uwayxs on 2017/11/1.
 * 忽略资源
 */
@WebFilter(filterName = "druidWebStatFilter",
           urlPatterns="/*",
           initParams = {
                @WebInitParam(name = "exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
           })
public class DruidStatFilter extends WebStatFilter {
}
