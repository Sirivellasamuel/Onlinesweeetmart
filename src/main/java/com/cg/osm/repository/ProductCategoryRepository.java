package com.cg.osm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.osm.entities.ProductCategory;
import com.cg.osm.entities.ProductCategory;


@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{

	
	
}