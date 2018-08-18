package com.firstmeetschool.school.service;


import com.firstmeetschool.school.shiro.MyRealm;
import com.github.kevinsawicki.http.HttpRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public String logincode(String code ,String state){

        String url ="https://api.weixin.qq.com/sns/jscode2session";
        String appid = "wx8a48e7acde322db1";
        String secret = "d1e571bb902ce5552ef9d499f01a94dd";
        String js_code = code;
        String grant_type = "authorization_code";

        HttpRequest request = HttpRequest.get(url, true, "appid",appid, "secret",secret,"js_code",js_code, "grant_type", grant_type);
        request.trustAllCerts();
        request.trustAllHosts();
        System.out.println(request.toString());
        System.out.println(request.body());

        /**
         * openid-数据库
         * 1.查询数据库有没有此openid
         * 2.有的话,就做token认证
         * 3.没有的话，状态码为1，表示用户授权，将openid存入数据库，并做token认证，
         *   状态码为0，表示用户未授权，不做token认证。
         */

        //自定义realm
        MyRealm myRealm= new MyRealm();

        //1.构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(myRealm);

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        System.out.println(session.getId());

        UsernamePasswordToken token = new UsernamePasswordToken("openid","123456");
        try {
            subject.login(token);
        }catch (AuthenticationException e){
            return e.getMessage();
        }

        System.out.println("是否认证:"+subject.isAuthenticated());


        if(subject.hasRole("user")){
            return "有admin权限";
        }

        return "无admin权限";

    }
}
