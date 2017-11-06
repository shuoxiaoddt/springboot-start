package com.uway.springboot.boot.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created by uwayxs on 2017/11/1.
 */
@WebServlet(urlPatterns = "/druid/*",
            initParams = {
                    @WebInitParam(name="allow",value = "127.0.0.1"),
                    @WebInitParam(name="loginUsername",value="admin"),
                    @WebInitParam(name="loginPassword",value="123456"),
                    @WebInitParam(name="resetEnable",value="false")//// 禁用HTML页面上的“Reset All”功能
            })
public class DruidStatViewServlet extends StatViewServlet {

    private static final long serialVersionUID = 1L;
}