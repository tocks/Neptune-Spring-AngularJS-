package com.neptune.services;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.business.UserBusiness;
import com.neptune.entities.User;

@RestController
public class UserRestService {
	
	@Autowired
	private UserBusiness userBusiness;

	public User saveUser(User u) {
		return userBusiness.saveUser(u);
	}
	
	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userBusiness.getAllUsers();
	}

	public User updateUser(String id) {
		return userBusiness.updateUser(id);
	}
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User findUser(String id) {
		return userBusiness.findUser(id);
	}

	public void deleteUser(String id) {
		userBusiness.deleteUser(id);
	}

	public List<User> getUserByRole() {
		return userBusiness.getUserByRole();
	}

	public List<User> getActivedUsers() {
		return userBusiness.getActivedUsers();
	}

	public Map<String, Object> getLogedUser(HttpServletRequest httpServletRequest) {
		return userBusiness.getLogedUser(httpServletRequest);
	}

}
