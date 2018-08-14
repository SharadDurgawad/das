package com.jwt.auth.service;

import com.jwt.auth.model.User;

public interface UserService {

	User getUserByUserName(String userName);
}
