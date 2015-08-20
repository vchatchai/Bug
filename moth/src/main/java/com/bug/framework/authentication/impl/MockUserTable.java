package com.bug.framework.authentication.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bug.framework.authentication.bean.User;

public class MockUserTable {
	private static Map<Integer, User> USER_MAP = new HashMap<Integer, User>();

	static {
		USER_MAP.put(1, new User(1, "admin", "admin@gmail.com", new Date()));
		USER_MAP.put(2, new User(2, "test", "test@gmail.com", new Date()));
	}

	public static void save(User user) {
		USER_MAP.put(user.getId(), user);
	}

	public static User getById(Integer id) {
		return USER_MAP.get(id);
	}

	public static List<User> getAll() {
		List<User> users = new ArrayList<User>(USER_MAP.values());
		return users;
	}

	public static void delete(Integer id) {
		USER_MAP.remove(id);
	}
}
