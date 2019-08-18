package com.bsnstrip.service.impl;

import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsnstrip.mapper.TUserMapper;
import com.bsnstrip.pojo.TEmployee;
import com.bsnstrip.pojo.TEmployeeExample;
import com.bsnstrip.pojo.TUser;
import com.bsnstrip.pojo.TUserExample;
import com.bsnstrip.pojo.TUserExample.Criteria;
import com.bsnstrip.service.UserService;
import com.bsnstrip.utils.MD5Utils;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private TUserMapper userMapper;

	// 通过主键查找用户
	public TUser findManagerByUserId(Integer userId) {

		TUser user = userMapper.findManagerByUserId(userId);
		return user;
	}
	// 通过用户名查找用户
	public TUser findUserByUsername(String username) {
		TUserExample example = new TUserExample();
		TUserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TUser> users = userMapper.selectByExample(example);

		TUser user = null;
		if (users != null && users.size() > 0) {
			user = users.get(0);
			return user;
		}else {
			return null;
		}
	}
	// 校验密码
	public boolean CheckPassword(String password, String md5Password) {
		boolean verify = MD5Utils.verify(password, md5Password);
		return verify;
	}
	public TUser getLeader() {
		TUser leader = userMapper.getLeader();
		return leader;
	}
	public TUser selectByPrimaryKey(Integer userid) {
		return userMapper.selectByPrimaryKey(userid);
	}
	public TUser getCounter() {
		return userMapper.getCounter();
	}
	public List<TUser> listUser() {
		TUserExample example = new TUserExample();
		List<TUser> users = userMapper.selectByExample(example);
		return users;
	}
	public Integer saveUser(TUser user) {
		Integer userid = user.getUserid();
		if(userid==null) {
			userMapper.insertSelective(user);
		}else {
			userMapper.updateByPrimaryKeySelective(user);
		}
		return user.getUserid();
	}
	
	public int deleteUser(Integer userId) {
		int i = userMapper.deleteByPrimaryKey(userId);
		return i;
	}
	public List<TUser> listDeptUser(Integer deptId) {
		TUserExample example = new TUserExample();
		TUserExample.Criteria criteria = example.createCriteria();
		criteria.andDeptidEqualTo(deptId);
		List<TUser> users = userMapper.selectByExample(example);
		return users;
	}
}
