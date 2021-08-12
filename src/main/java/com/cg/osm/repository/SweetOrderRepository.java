package com.cg.osm.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cg.osm.entities.SweetOrder;


@Repository
public interface SweetOrderRepository extends JpaRepository<SweetOrder, Integer>{

	
	
	
	
}