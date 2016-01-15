package com.neptune.business;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.neptune.entities.User;

public interface UserBusiness {
	
	public User saveUser(User u);

	public List<User> getAllUsers();

	public User updateUser(String id);

	public User findUser(String id);

	public void deleteUser(String id);
	
	public List<User>getUserByRole();
	
	public List<User>getActivedUsers();
	

	public Map<String, Object> getLogedUser(HttpServletRequest httpServletRequest);

}
