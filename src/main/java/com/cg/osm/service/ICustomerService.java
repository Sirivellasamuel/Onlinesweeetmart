package com.cg.osm.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cg.osm.entities.Customer;
import com.cg.osm.exception.CustomerNotFoundException;

@Service
public interface ICustomerService {

	Customer addCustomer(Customer customer);

	List<Customer> fetchAll();

	void delCustomer(int id) throws CustomerNotFoundException;

	void updateCustomer(Customer customer);

	Customer fetchById(int id) throws CustomerNotFoundException;

	/*Customer getByLastName(String lastName);*/

	/*Customer getByFirstName(String firstName);*/

	

}