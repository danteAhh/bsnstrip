package com.bsnstrip.pojo;

import java.util.List;

public class ActiveUser{
	
	private Integer userid;

    private String username;

    private String password;

    private String salt;

    private List<TPermission> menus;
    private List<TPermission> permissions;

	public List<TPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<TPermission> permissions) {
		this.permissions = permissions;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public List<TPermission> getMenus() {
		return menus;
	}

	public void setMenus(List<TPermission> menus) {
		this.menus = menus;
	}


}
