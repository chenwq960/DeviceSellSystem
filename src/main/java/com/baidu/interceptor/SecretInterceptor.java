package com.baidu.interceptor;

import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.controller.UserController;
import com.baidu.po.AuthInfoPO;

public class SecretInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(SecretInterceptor.class);

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        // 初始化当前上下文，
        CurrentContext.init(request);

        // 判断上下文中是否存在登录用户
        if (Objects.isNull(CurrentContext.getUser())) {
            response.sendRedirect(request.getContextPath() + "/views/error/relogin.jsp");
            return false;
        }
        else {
            Set<String> currentUserAuthUrls = (Set<String>) request.getSession().getAttribute("currentUserAuthUrls");
            if (Objects.nonNull(currentUserAuthUrls) && currentUserAuthUrls.contains(request.getServletPath())) {
                return true;
            }
            else {
                response.sendRedirect(request.getContextPath() + "/views/error/authError.jsp");
                return false;
            }

        }
    }

}
