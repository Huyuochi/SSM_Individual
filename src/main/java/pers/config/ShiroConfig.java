package pers.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.myshiro.MRealm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 自定义shiro配置,自定义realm,后装入securityManager中,由securityManager负责安全与权限操作
 */
@Configuration
public class ShiroConfig {

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("sha-256");
        hashedCredentialsMatcher.setHashIterations(4);
        return hashedCredentialsMatcher;
    }

    @Bean
    public MRealm realm(HashedCredentialsMatcher hashedCredentialsMatcher) {
        MRealm mRealm = new MRealm();
        mRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return mRealm;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(MRealm mRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(mRealm);
        return securityManager;
    }

    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean Filter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //全局绑定Manager和SecurityUtil
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //设置拦截器,无权限则无法访问,此处设置随意访问
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/**","anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

}
