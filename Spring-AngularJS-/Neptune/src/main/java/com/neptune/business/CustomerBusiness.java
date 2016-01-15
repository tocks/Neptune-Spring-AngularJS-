package com.neptune.business;
/**
 * @author Boubacar KOITA alias Tocka
 * Customer: business interface
 */
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import com.neptune.entities.Customer;
import com.neptune.entities.User;

public interface CustomerBusiness {
	
	public Customer saveCustomer(Customer c);

	public List<Customer> getAllCustomers();

	public Customer updateCustomer(Long id);

	public Customer findCustomer(Long id);

	public void deleteCustomer(Long id);
	
	public List<Customer>getCustmerByOwner();
	
	public List<Customer>getCustmerByStatus();
	
	public String printUser();
	
	public User getUserByUsername(String username);
	
	public Map<String, Object> getLogedUser(HttpServletRequest httpServletRequest);
	
}
