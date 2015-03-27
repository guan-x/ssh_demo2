package cn.gx.domain.view;

import java.util.List;
/**
 * session中的用户信息
 * @author always_w_u
 *
 */
public class SessionUser {

	private Long id;//用户id
	private String name;//用户登录�?
	private String ip;//用户ip
	
	private Long roleId;//角色id
	
	private List<String> privilgeURL;//用户可以访问的资源地�?
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<String> getPrivilgeURL() {
		return privilgeURL;
	}

	public void setPrivilgeURL(List<String> privilgeURL) {
		this.privilgeURL = privilgeURL;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}
