package com.firstmeetschool.school.shiro;



import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager manager){
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean= new ShiroFilterFactoryBean();

        //设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(manager);
        //拦截器
        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<String, String>();
        //配置不会被拦截的链接 顺序判断

        filterChainDefinitionMap.put("/users","anon");
        filterChainDefinitionMap.put("/hello","anon");
        filterChainDefinitionMap.put("/login_code/**","anon");
        filterChainDefinitionMap.put("/","anon");
        //配置退出 过滤器，其中的具体的退出代码shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout","logout");
        //<!--过滤链定义，从上向下顺序执行，一般将/**放在最为下边-->：这是一个坑呢，一不小心代码就不好使了；
        //<!--authc:所有url都必须认证通过才可以访问;anon:所有url都可以匿名访问-->
        filterChainDefinitionMap.put("/**","authc");

        //如果不设置默认会自动寻找web工程跟目录下的"login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("login");
        //登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/users");

        //未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();

        return myRealm;
        }


    @Bean
    public SecurityManager securityManager(){
        System.out.println("------------------shiro已经加载--------------------");
        DefaultWebSecurityManager manager= new DefaultWebSecurityManager();
        manager.setRealm(myRealm());
        return manager;

    }


}

