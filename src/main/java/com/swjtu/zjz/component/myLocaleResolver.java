package com.swjtu.zjz.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 作用：通过解析主页的链接携带的参数l，来进行语言的转换。
 *      接口LocaleResolver：在SpringBoot的自动配置中重写该接口，实现了调用浏览器语言的功能
 *      这里重写该接口，重新设计功能，来替换SpringBoot的自动配置。
 *      Locale：该类对应浏览器的本地语言
 */
public class myLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        Locale locale = Locale.getDefault();    //使用浏览器的默认语言选项
        String l = httpServletRequest.getParameter("l");
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
    }
}
