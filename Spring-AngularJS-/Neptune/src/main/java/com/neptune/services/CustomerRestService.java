package com.neptune.services;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.business.CustomerBusiness;
import com.neptune.entities.Customer;

@RestController
public class CustomerRestService {

	@Autowired
	private CustomerBusiness customerBusiness;

	@Secured(value = { "ROLE_ADMIN", "ROLE_MANAGER" })
	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public Customer saveCustomer(@RequestBody Customer c) {
		return customerBusiness.saveCustomer(c);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		return customerBusiness.getAllCustomers();
	}

	// @Secured(value={"ROLE_ADMIN","ROLE_MANAGER"})
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
	public Customer updateCompany(@PathVariable Long id) {
		return customerBusiness.updateCustomer(id);
	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
	public Customer findCompany(@PathVariable Long id) {
		return customerBusiness.findCustomer(id);
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_MANAGER" })
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
	public void deleteCompany(@PathVariable Long id) {
		customerBusiness.deleteCustomer(id);
	}

	@RequestMapping(value = "/custmersByOwner", method = RequestMethod.GET)
	public List<Customer> getCustmerByOwner() {
		return customerBusiness.getCustmerByOwner();
	}

	public List<Customer> getCustmerByStatus() {
		return customerBusiness.getCustmerByStatus();
	}

	@RequestMapping(value = "/getLogedUser", method = RequestMethod.GET)
	public Map<String, Object> getLogedUser(HttpServletRequest httpServletRequest) {
		return customerBusiness.getLogedUser(httpServletRequest);
	}

	public Customer updateCustomer(Long id) {
		return customerBusiness.updateCustomer(id);
	}

	public Customer findCustomer(Long id) {
		return customerBusiness.findCustomer(id);
	}

	public void deleteCustomer(Long id) {
		customerBusiness.deleteCustomer(id);
	}

	@RequestMapping(value = "/logedUser", method = RequestMethod.GET)
	public String printUser() {
		return customerBusiness.printUser();
	}

	
	
}
