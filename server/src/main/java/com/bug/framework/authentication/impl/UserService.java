package com.bug.framework.authentication.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bug.framework.authentication.bean.User;

@Service
public class UserService {
	public void save(User user) {
		MockUserTable.save(user);
	}

	public User getById(Integer id) {
		return MockUserTable.getById(id);
	}

	public List<User> getAll() {
		return MockUserTable.getAll();
	}

	public void delete(Integer id) {
		MockUserTable.delete(id);
	}
}
