package com.swjtu.zjz.component;

import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Map;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(user == null){
            /* 这里是另外一种页面跳转，但是失败了*/
            /*
            //未登录,返回登录页
            request.setAttribute("msg","没有权限，请先登录");
            System.out.println("转发之前已经运行");
            request.getRequestDispatcher("/").forward(request,response);
            System.out.println("转发后已经运行！");
            response.sendRedirect("/index");
            return false;
            request.setAttribute("msg","没有权限，请先登录");
        */
//            request.getSession().setAttribute("message","没有权限，请先登录");
//            System.out.println(session.getAttribute("message"));
//            System.out.println("测试一下：页面跳转前进行输出");
//            System.out.println("测试一下：页面跳转后进行输出");

            response.sendRedirect("/login");
            return false;
        }else {
            //已登录
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
