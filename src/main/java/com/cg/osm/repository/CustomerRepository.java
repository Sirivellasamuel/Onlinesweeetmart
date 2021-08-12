package com.cg.osm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.osm.dto.OrderResponse;
import com.cg.osm.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	/*public Customer findByLastName(String lastName);*/

	/*public Customer findByFirstName(String firstName);*/

	/*@Query("SELECT new com.cg.fms.dto.OrderResponse(c.Name) FROM Customer c JOIN c.products p")
	public List<OrderResponse> getJoinInfo();*/
}