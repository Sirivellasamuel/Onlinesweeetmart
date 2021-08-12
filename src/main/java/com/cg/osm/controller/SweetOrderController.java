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
import com.cg.osm.entities.SweetOrder;
import com.cg.osm.exception.SweetOrderNotFoundException;
import com.cg.osm.service.ISweetOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/SweetOrder")
public class SweetOrderController {

	Logger logger = LoggerFactory.getLogger(SweetOrderController.class);
	
	@Autowired
	private ISweetOrderService service;
	
	
	
	
	
	@GetMapping("/getById/{SweetOrdernumber}") 
	@ApiOperation("Get SweetOrder By SweetOrderNumber")
	public SweetOrder fetchById(@PathVariable int SweetOrdernumber) throws SweetOrderNotFoundException {
		logger.info("Inside fetchById %s", SweetOrdernumber);
		return service.fetchById(SweetOrdernumber);
	}
		
	
		
		
	@PostMapping("/save")
	@ApiOperation("Add a new SweetOrder")
	public ResponseEntity<SweetOrder> save(@Valid @RequestBody SweetOrder SweetOrder) {
		logger.info("Adding a SweetOrder : " + SweetOrder);
		SweetOrder Swor = service.addSweetOrder(SweetOrder);
		return new ResponseEntity<>(Swor, HttpStatus.CREATED);
	}
	
	
	
	
	@PutMapping("/update")
	@ApiOperation("Update an Existing SweetOrder")
	public void update(@Valid @RequestBody SweetOrder SweetOrder) {
		logger.info("Updating a SweetOrder details!!");
		service.updateSweetOrder(SweetOrder);
	}
	
	
	
	
	@DeleteMapping("/delete/{SweetOrdernumber}")
	@ApiOperation("Delete an Existing SweetOrder")
	public ResponseEntity<Void> delete(@PathVariable int SweetOrdernumber) throws SweetOrderNotFoundException {
		logger.info("Deleting a SweetOrder!!");
		service.delSweetOrder(SweetOrdernumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	// get all product
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all SweetOrder Details")
	public List<SweetOrder> fetch() {
	logger.info("Fetching all SweetOrder!");
	return service.fetchAll();
	}
	
}
