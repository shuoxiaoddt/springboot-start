package com.uway.springboot.boot.config;

import com.uway.springboot.boot.entity.Permission;
import com.uway.springboot.boot.entity.Role;
import com.uway.springboot.boot.entity.UserInfo;
import com.uway.springboot.boot.service.UserInfoService;
import javax.annotation.Resource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * Created by uwayxs on 2017/11/7.
 */
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserInfoService userInfoService;
    /**
     * 此方法调用  hasRole,hasPermission的时候才会进行回调.
     *
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("ShiroRealm.doGetAuthorizationInfo() ==> 权限管理 start");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();

        for(Role role:userInfo.getRoles()){
            authorizationInfo.addRole(role.getRole());
            for(Permission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }


    /**
     * 认证信息.(身份验证)
     * :
     * Authentication 是用来验证用户身份
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("ShiroRealm.doGetAuthenticationInfo() ==> 身份验证 start");
        String username = (String) token.getPrincipal();
        //查询数据库
        UserInfo userInfo = userInfoService.findByUsername(username);
        System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo,userInfo.getPasspwd(), ByteSource.Util.bytes(userInfo.getCredentialsSalt()),getName()
        );

        return authenticationInfo;
    }
}
