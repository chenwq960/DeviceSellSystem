package com.baidu.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.baidu.po.UserPO;

/**
 * 当前线程上下文的状态参数，主要是当前用户身份信息
 * 
 * @author songyz
 * @createTime 2020-01-16 18:48:58
 */
public final class CurrentContext {

    private static ThreadLocal<Context> threadLocal = new InheritableThreadLocal<Context>();

    private CurrentContext() {
    }

    private static Context getContext() {
        Context context = threadLocal.get();
        if (Objects.isNull(context)) {
            context = new Context();
            threadLocal.set(context);
        }

        return context;
    }

    static void init(HttpServletRequest request) {
        Context context = getContext();
        context.setPath(request);
    }

    public static Context get() {
        return getContext();
    }

    public static void setUser(UserPO user) {
        Context context = getContext();
        context.user = user;
    }

    public static UserPO getUser() {
        return getContext().user;
    }

    public static void setSession(HttpSession session) {
        Context context = getContext();
        context.session = session;
    }

    public static HttpSession getSession() {
        return getContext().session;
    }

    public static class Context {
        HttpSession session;
        String path = "";
        UserPO user;

        void setPath(HttpServletRequest request) {
            this.path = request.getRequestURI();
            this.session = request.getSession();
            this.user = (UserPO) request.getSession().getAttribute("currentUser");
        }
    }

}
