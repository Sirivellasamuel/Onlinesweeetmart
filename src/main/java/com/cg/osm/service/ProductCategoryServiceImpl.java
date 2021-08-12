package com.cg.osm.service;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.osm.exception.ProductCategoryNotFoundException;
import com.cg.osm.entities.ProductCategory;
import com.cg.osm.repository.ProductCategoryRepository;
import com.cg.osm.service.ProductCategoryServiceImpl;


@Service
public class ProductCategoryServiceImpl implements IProductCategoryService{
	
	Logger logger = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);
	
	@Autowired
	private ProductCategoryRepository repository;     //DEPENDENCY OF IMPLEMENTATION

	
	
	                  //GETTING PRODUCT BY ID
	@Override
	public ProductCategory fetchById(int id) throws ProductCategoryNotFoundException {
		Optional<ProductCategory> productCategory = repository.findById(id);
		if (!productCategory.isPresent())
			throw new ProductCategoryNotFoundException();
		return productCategory.get();
	}
	

	
	                  //ADDING A NEW PRODUCT
	
	@Override
	public ProductCategory addProductCategory(ProductCategory productCategory) {
		logger.info("inside addProduct method of ProductServiceImpl");
		return repository.save(productCategory);
	}
	
	
					//UPDATE EXISTING PRODUCT 
	
	@Override
	public void updateProductCategory(ProductCategory ProductCategory) {
		repository.save(ProductCategory);
	}
	
	
				//DELETING AN EXISTING PRODUCT WITH ID
	
	@Override
	public void delProductCategory(int id) throws ProductCategoryNotFoundException{
		Optional<ProductCategory> productCategory = repository.findById(id);
		if (!productCategory.isPresent())
			throw new ProductCategoryNotFoundException();

		repository.deleteById(id);
	}
		
	
	
					// LIST ALL PRODUCTS
	@Override
	public List<ProductCategory> fetchAll() {
		return repository.findAll();
	}
}