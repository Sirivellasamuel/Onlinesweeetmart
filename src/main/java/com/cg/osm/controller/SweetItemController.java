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
import com.cg.osm.entities.SweetItem;
import com.cg.osm.exception.SweetItemNotFoundException;
import com.cg.osm.service.ISweetItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/SweetItem")
public class SweetItemController {

	Logger logger = LoggerFactory.getLogger(SweetItemController.class);
	
	@Autowired
	private ISweetItemService service;
	
	
	
	
	
	@GetMapping("/getById/{SweetItemnumber}") 
	@ApiOperation("Get SweetItem By SweetItemNumber")
	public SweetItem fetchById(@PathVariable int SweetItemnumber) throws SweetItemNotFoundException {
		logger.info("Inside fetchById %s", SweetItemnumber);
		return service.fetchById(SweetItemnumber);
	}
		
	
		
		
	@PostMapping("/save")
	@ApiOperation("Add a new SweetItem")
	public ResponseEntity<SweetItem> save(@Valid @RequestBody SweetItem SweetItem) {
		logger.info("Adding a SweetItem : " + SweetItem);
		SweetItem Swit = service.addSweetItem(SweetItem);
		return new ResponseEntity<>(Swit, HttpStatus.CREATED);
	}
	
	
	
	
	@PutMapping("/update")
	@ApiOperation("Update an Existing SweetItem")
	public void update(@Valid @RequestBody SweetItem SweetItem) {
		logger.info("Updating a SweetItem details!!");
		service.updateSweetItem(SweetItem);
	}
	
	
	
	
	@DeleteMapping("/delete/{SweetItemnumber}")
	@ApiOperation("Delete an Existing SweetItem")
	public ResponseEntity<Void> delete(@PathVariable int SweetItemnumber) throws SweetItemNotFoundException {
		logger.info("Deleting a SweetItem!!");
		service.delSweetItem(SweetItemnumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	// get all product
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all SweetItem Details")
	public List<SweetItem> fetch() {
	logger.info("Fetching all SweetItem!");
	return service.fetchAll();
	}
	
}
