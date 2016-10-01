package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {
	private Map<String, Customer> customers;

	private static final CustomerService instance = new CustomerService();
	
	private CustomerService() {
		customers = new HashMap<String, Customer>();
		
		addCustomer(new Customer("id001", "1234", "kim", "m", "kim@hansung.ac.kr"));
		addCustomer(new Customer("id002", "1234", "lee", "m", "lee@hansung.ac.kr"));

	}
	public static CustomerService getInstance() {	//싱글톤. 하나의 객체만 생성되게.
		return instance;
	}
	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	} 
	
	public Customer findCustomer(String id) {
		if(id != null)
			return (customers.get(id.toLowerCase()));	//입력한 값 소문자로 바꿔서, get함수 호출.
		else
			return null;
	}
	public Customer login(String id, String password) {
		if(id!= null) {
			if(this.findCustomer(id) == null)
				return null;
			else if(password.equals( customers.get(id).getPassword() ))
				return (customers.get(id.toLowerCase()));
			else
				return null;
		}
		else
			return null;
	}
}
