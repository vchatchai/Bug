package com.bug.framework.authentication.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.bug.AppMain;
import com.bug.framework.authentication.dao.AuthenticationDao;
import com.bug.framework.authentication.dao.impl.AuthenticationDaoImpl;
import com.bug.framework.authentication.realm.CassandraSecurityRealm;

@Configuration
public class SecurityConfig {

	@Autowired
	SecurityManager securityManager;

	@Bean
	public AuthenticationDao getAuthenticationDao() {
		return (AuthenticationDao) new AuthenticationDaoImpl();

	}

	@Bean
	public CassandraSecurityRealm customSecurityRealm() {
		return new CassandraSecurityRealm(getAuthenticationDao());
	}
	//
	// @Bean
	// public WebSecurityManager securityManager(){
	// DefaultWebSecurityManager securityManager = new
	// DefaultWebSecurityManager();
	// securityManager.setRealm(customSecurityRealm());
	//
	// return securityManager;
	// }

	@Bean
	public SecurityManager securityManager() {
		DefaultSecurityManager securityManager = null;
		if (AppMain.isStandalone()) {
			securityManager = new DefaultSecurityManager();
			DefaultSessionManager defaultSessionManager = new DefaultSessionManager();
			securityManager.setSessionManager(defaultSessionManager);

		} else {
			securityManager = new DefaultWebSecurityManager();
			DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
			securityManager.setSessionManager(defaultWebSessionManager);
		}

		securityManager.setRealm(customSecurityRealm());
		//
		//
		// Factory<org.apache.shiro.mgt.SecurityManager> factory = new
		// IniSecurityManagerFactory(
		// "classpath:com/bug/config/shiro.ini");
		// SecurityManager securityManager = factory.getInstance();

		MemoryConstrainedCacheManager constrainedCacheManager = new MemoryConstrainedCacheManager();
		securityManager.setCacheManager(constrainedCacheManager);

		// DefaultWebSessionManager defaultWebSessionManager = new
		// DefaultWebSessionManager();

		// securityManager.setSessionManager(defaultWebSessionManager);

		return securityManager;
	}

	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public MethodInvokingFactoryBean methodInvokingFactoryBean() {
		MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
		methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
		methodInvokingFactoryBean.setArguments(new Object[] { securityManager() });
		return methodInvokingFactoryBean;
	}

	@Bean
	@DependsOn(value = "lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		return new DefaultAdvisorAutoProxyCreator();
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
		SecurityUtils.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilter() {
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		Map<String, String> definitionsMap = new HashMap<String, String>();
		definitionsMap.put("/rest/**", "authc");
		shiroFilter.setFilterChainDefinitionMap(definitionsMap);
		// shiroFilter.setLoginUrl("/signin");
		// shiroFilter.setUnauthorizedUrl("/index");
		shiroFilter.setSecurityManager(securityManager);

		return shiroFilter;
	}
}