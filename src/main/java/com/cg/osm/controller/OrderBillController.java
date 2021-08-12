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
import com.cg.osm.entities.OrderBill;
import com.cg.osm.exception.OrderBillNotFoundException;
import com.cg.osm.service.IOrderBillService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/OrderBill")
public class OrderBillController {

	Logger logger = LoggerFactory.getLogger(OrderBillController.class);
	
	@Autowired
	private IOrderBillService service;
	
	
	
	
	
	@GetMapping("/getById/{OrderBillnumber}") 
	@ApiOperation("Get OrderBill By OrderBillNumber")
	public OrderBill fetchById(@PathVariable int OrderBillnumber) throws OrderBillNotFoundException {
		logger.info("Inside fetchById %s", OrderBillnumber);
		return service.fetchById(OrderBillnumber);
	}
		
	
		
		
	@PostMapping("/save")
	@ApiOperation("Add a new OrderBill")
	public ResponseEntity<OrderBill> save(@Valid @RequestBody OrderBill OrderBill) {
		logger.info("Adding a OrderBill : " + OrderBill);
		OrderBill ordr = service.addOrderBill(OrderBill);
		return new ResponseEntity<>(ordr, HttpStatus.CREATED);
	}
	
	
	
	
	@PutMapping("/update")
	@ApiOperation("Update an Existing OrderBill")
	public void update(@Valid @RequestBody OrderBill OrderBill) {
		logger.info("Updating a OrderBill details!!");
		service.updateOrderBill(OrderBill);
	}
	
	
	
	
	@DeleteMapping("/delete/{OrderBillnumber}")
	@ApiOperation("Delete an Existing OrderBill")
	public ResponseEntity<Void> delete(@PathVariable int OrderBillnumber) throws OrderBillNotFoundException {
		logger.info("Deleting a OrderBill!!");
		service.delOrderBill(OrderBillnumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	// get all product
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all OrderBill Details")
	public List<OrderBill> fetch() {
	logger.info("Fetching all OrderBill!");
	return service.fetchAll();
	}
	
}
