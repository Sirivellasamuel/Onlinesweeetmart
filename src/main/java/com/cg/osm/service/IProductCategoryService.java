package com.cg.osm.service;

import com.cg.osm.exception.ProductCategoryNotFoundException;
import com.cg.osm.entities.ProductCategory;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.osm.entities.ProductCategory;

@Service
public interface IProductCategoryService {

	
	//get product by id//
	ProductCategory fetchById(int id) throws ProductCategoryNotFoundException;
	
	// adding a product //
	ProductCategory addProductCategory(ProductCategory product);
	
	//updating a product //
	void  updateProductCategory(ProductCategory product);
	
	//deleting a product //
	void delProductCategory(int id) throws ProductCategoryNotFoundException;
	
	// get all products //
	List<ProductCategory> fetchAll();
}
