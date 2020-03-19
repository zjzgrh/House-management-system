package com.swjtu.zjz.config;


import com.swjtu.zjz.component.LoginHandlerInterceptor;
import com.swjtu.zjz.component.myLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class myMvcConfig implements WebMvcConfigurer {
    /**
     * 作用：添加映射关系，urlPath:是网站的请求路径，后面的是静态资源路径下的templates文件夹下的文件。
     * 原理：通过重写addViewControllers()方法来实现，
     *      重写addViewControllers()方法需要继承WebMvcConfigurer接口
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/main.html").setViewName("index");
        registry.addViewController("/rent_main.html").setViewName("rent/index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/houselist").setViewName("houselist");
        registry.addViewController("/signin").setViewName("signin");
        registry.addViewController("/success").setViewName("success");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/","/user/login","/login","/static/**","/signin","/user/signin","/success");
    }

    /**
     * 作用：@Bean的作用是将该函数作为一个组件替换SpringBoot的自动配置
     *      该方法的作用是：调用一个类，实现通过点击链接来切换语言
     *      SpringBoot的自动配置浏览器语言的类的名字就是localeResolver
     *      自动配置使用的是：开发者不进行配置就使用自动配置，否则就使用开发者设置的配置
     *      SpringBoot的自动配置类：WebMvcAutoConfiguration
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new myLocaleResolver();
    }
 }
