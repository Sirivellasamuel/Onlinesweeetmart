package com.cg.osm.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cg.osm.entities.Customer;
import com.cg.osm.exception.CustomerNotFoundException;
import com.cg.osm.service.ICustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Customer")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private ICustomerService service;
	
	
	
	
	
	@GetMapping("/getById/{Customernumber}") 
	@ApiOperation("Get Customer By CustomerNumber")
	public Customer fetchById(@PathVariable int Customernumber) throws CustomerNotFoundException {
		logger.info("Inside fetchById %s", Customernumber);
		return service.fetchById(Customernumber);
	}
		
	
		
		
	@PostMapping("/save")
	@ApiOperation("Add a new Customer")
	public ResponseEntity<Customer> save(@Valid @RequestBody Customer Customer) {
		logger.info("Adding a Customer : " + Customer);
		Customer Swit = service.addCustomer(Customer);
		return new ResponseEntity<>(Swit, HttpStatus.CREATED);
	}
	
	
	
	
	@PutMapping("/update")
	@ApiOperation("Update an Existing Customer")
	public void update(@Valid @RequestBody Customer Customer) {
		logger.info("Updating a Customer details!!");
		service.updateCustomer(Customer);
	}
	
	
	
	
	@DeleteMapping("/delete/{Customernumber}")
	@ApiOperation("Delete an Existing Customer")
	public ResponseEntity<Void> delete(@PathVariable int Customernumber) throws CustomerNotFoundException {
		logger.info("Deleting a Customer!!");
		service.delCustomer(Customernumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	// get all product
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all Customer Details")
	public List<Customer> fetch() {
	logger.info("Fetching all Customer!");
	return service.fetchAll();
	}
	
}
