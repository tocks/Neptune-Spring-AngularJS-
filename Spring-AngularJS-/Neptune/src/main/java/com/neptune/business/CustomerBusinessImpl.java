package com.neptune.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neptune.dao.CustomerRepository;
import com.neptune.dao.UserRepository;
import com.neptune.entities.Customer;
import com.neptune.entities.User;

/**
 * @author Boubacar KOITA alias Tocka Customer: business implementation class
 */

@Service
@Transactional
public class CustomerBusinessImpl implements CustomerBusiness {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserRepository userRepository;

	HttpServletRequest httpServletRequest;

	@Override
	public Customer saveCustomer(Customer c) {
		
		customerRepository.save(c);
		
		//String username = printUser();
		//User owner = getUserByUsername(username);
	//	c.setOwner(owner);;
		return c;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(Long id) {

		Customer c = customerRepository.findOne(id);
		if (null != c) {
			return customerRepository.save(c);
		}

		return c;
	}

	@Override
	public Customer findCustomer(Long id) {
		return customerRepository.findOne(id);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.delete(id);
	}

	@Override
	public List<Customer> getCustmerByOwner() {
		String username = printUser();
		User owner = getUserByUsername(username);
		return customerRepository.getCustmerByOwner(owner.getUsername());
	}

	@Override
	public List<Customer> getCustmerByStatus() {
		return null;
	}

	/**
	 * recuperer l'utilisateur connecté
	 * 
	 * @param httpServletRequest
	 * @return
	 */

	public Map<String, Object> getLogedUser(HttpServletRequest httpServletRequest) {
		HttpSession httpSession = httpServletRequest.getSession();
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");

		String username = securityContext.getAuthentication().getName();
		List<String> roles = new ArrayList<>();

		for (GrantedAuthority ga : securityContext.getAuthentication().getAuthorities()) {
			roles.add(ga.getAuthority());
		}

		Map<String, Object> parms = new HashMap<>();
		parms.put("username", username);
		parms.put("roles", roles);

		return parms;
	}

	//return the loged user id=username
	@Override
	public String printUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		System.out.println(name);
		return name;

	}

	@Override
	public User getUserByUsername(String username) {
		
		return userRepository.getUserByUsername(username);
	}

}
