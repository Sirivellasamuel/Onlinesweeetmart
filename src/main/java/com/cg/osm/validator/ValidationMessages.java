package com.cg.osm.validator;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.cg.osm.exception.CartNotFoundException;
import com.cg.osm.exception.CustomerNotFoundException;
import com.cg.osm.exception.OrderBillNotFoundException;
import com.cg.osm.exception.ProductCategoryNotFoundException;
import com.cg.osm.exception.*;
import com.cg.osm.exception.SweetItemNotFoundException;


@ControllerAdvice
public class ValidationMessages extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(value = CartNotFoundException.class)
	public ResponseEntity<Object> exception3(CartNotFoundException exception) {

		return new ResponseEntity<>(" cart already exist !! ", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<Object> exception3(CustomerNotFoundException exception) {

		return new ResponseEntity<>(" Customer already exist  !! ", HttpStatus.NOT_FOUND);

	}
	
	
	
	@ExceptionHandler(value = OrderBillNotFoundException.class)
	public ResponseEntity<Object> exception3(OrderBillNotFoundException exception) {

		return new ResponseEntity<>(" OrderBill already exist  !! ", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = ProductCategoryNotFoundException.class)
	public ResponseEntity<Object> exception3(ProductCategoryNotFoundException exception) {

		return new ResponseEntity<>(" Product already exist  !! ", HttpStatus.NOT_FOUND);

	}
	
	
	@ExceptionHandler(value = SweetItemNotFoundException.class)
	public ResponseEntity<Object> exception4(SweetItemNotFoundException exception) {

		return new ResponseEntity<>(" SweetItem does not exist !! ", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = SweetOrderNotFoundException.class)
	public ResponseEntity<Object> exception4(SweetOrderNotFoundException exception) {

		return new ResponseEntity<>(" SweetOrder does not exist ", HttpStatus.NOT_FOUND);
	}

	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

}