package com.firstmeetschool.school.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {



   /* private UserMapper userMapper;*/


    /**
     * 获取授权信息
     * @param principalCollection
     * @return
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("----------权限认证-----------");
        String username= (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        //获得该用户的角色
       /* String role = userMapper.getRole(username);*/
        Set<String> set= new HashSet<>();
        //需要将role封装到Set作为info.setRoles()的参数

        /*set.add(role);*/
         set.add("user");
         set.add("admin");
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }

    /**
     * 用于认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("使用了自定义的realm，用户认证。。。");
        System.out.println("用户名:"+((UsernamePasswordToken) authenticationToken).getUsername());
        System.out.println("密码:"+ new String(((UsernamePasswordToken) authenticationToken).getPassword()));

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;


        //获取用户名
       /* String password=userMapper.getPassword(token.getUsername());
        if (null==password){
            System.out.println("用户名不正确");
            //throw new AccountException("用户名不正确");
        }else if(!password.equals(new String((char[])token.getCredentials()))){
            System.out.println("密码不正确");
            //throw new AccoutException("密码不正确");
        }*/

        //依据用户名去数据库查询
        //模拟从数据库中查询出来的散列值密码


        //查询到了数据，验证密码是否正确
        //密码正确，认证通过
        //密码错误，认证失败
        //没有查询到数据，认证失败


        //模拟从数据库获取salt
        String salt="qwerty";

        return new SimpleAuthenticationInfo(token.getPrincipal(),"123456",getName());
    }
}
