package com.softveri.service;

import java.util.List;
import com.softveri.entity.User;

public interface UserService {

	public List<User> getAllUsers();
	public boolean saveUser(User user);
}