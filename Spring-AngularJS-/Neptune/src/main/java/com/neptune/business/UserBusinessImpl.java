package com.neptune.business;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neptune.dao.UserRepository;
import com.neptune.entities.User;

@Service
@Transactional
public class UserBusinessImpl implements UserBusiness {

	private UserRepository userRepository;

	@Override
	public User saveUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(String id) {

		return userRepository.save(findUser(id));
	}

	@Override
	public User findUser(String id) {
		return userRepository.findOne(id);
	}

	@Override
	public void deleteUser(String id) {
		userRepository.delete(id);
	}

	@Override
	public List<User> getUserByRole() {
		return null;
	}

	@Override
	public List<User> getActivedUsers() {
		return null;
	}

	@Override
	public Map<String, Object> getLogedUser(HttpServletRequest httpServletRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
