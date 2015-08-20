package com.bug.framework.authentication.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CassandraSecurityRealm extends AuthorizingRealm {

	// @Autowired
	// private UserManager userManager;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		Set<String> roles = new HashSet<>();
		Set<Permission> permissions = new HashSet<>();
		// Collection principalsList = principals.byType(User.class);
		// for (User user : principalsList) {
		// for (Role role : user.getRoles()) {
		// roles.add(role.getName());
		// for (Iterator iterator = role.getPermissions().iterator();
		// iterator.hasNext(); ) {
		// Permission permission = iterator.next();
		// permissions.add(new WildcardPermission(permission.name()));
		// }
		// }
		// }
		Permission permission = new WildcardPermission("employee:create");

		permissions.add(permission);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		info.setRoles(roles);
		info.setObjectPermissions(permissions);
		setAuthenticationCachingEnabled(false);
		setCachingEnabled(false);
		// setCacheManager( );
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upat = (UsernamePasswordToken) token;
		// User user = userManager.getByUsername(upat.getUsername());
		// if(user != null && user.getPassword().equals(new
		// String(upat.getPassword()))) {
		// return new SimpleAuthenticationInfo(user, user.getPassword(),
		// getName());
		// }
		// else {
		// throw new AuthenticationException("Invalid username/password
		// combination!");
		// }
		return new SimpleAuthenticationInfo(upat.getPrincipal(), upat.getCredentials(), "create");

	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}
}