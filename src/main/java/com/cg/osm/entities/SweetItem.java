package com.cg.osm.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cg.osm.repository.SweetItemRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SweetItem_tbl")             
public class SweetItem {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@Column(name = "SweetItemName")       
	@NotNull
	@Size(min = 3, message = "Product Name should have mininum 3 characters!!")
	private String name;
	
	@Column(name = "SweetAvailability")       
	@NotNull
	@Size(min = 3, message = "Product Name should have mininum 3 characters!!")
	private String availability;
	
	
	
	
}


