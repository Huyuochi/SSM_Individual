package pers.myshiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import pers.entity.User;
import pers.service.UserService;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class MRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo
                = new SimpleAuthorizationInfo();
        String account = (String)principalCollection.getPrimaryPrincipal();
        User user = userService.FindUserByAccount(account);
        Set<String> roles = new HashSet<String>();
        if(user.getAccount() != "Aki") {
            roles.add("commonUser");
            System.out.println("I'm a common user");
        } else {
            roles.add("admin");
            System.out.println("I'm a admin");
        }
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account = (String)token.getPrincipal();
        User user = userService.FindUserByAccount(account);
        SimpleAuthenticationInfo simpleAuthenticationInfo
                = new SimpleAuthenticationInfo(user.getAccount(),
                    user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        return simpleAuthenticationInfo;
    }
}
