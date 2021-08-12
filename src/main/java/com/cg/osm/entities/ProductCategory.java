package com.cg.osm.entities;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data                                
@NoArgsConstructor           
@Entity                                   
@Table(name = "Product_tbl")      
    public class ProductCategory {
	
	@Id                               
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "productName")       
	@NotNull
	@Size(min = 3, message = "Product Name should have mininum 3 characters!!")
	private String name;
	
	@Column(name = "Description")       
	@NotNull
	@Size(min = 3, message = "Product Name should have mininum 100 characters!!")
	private String description;
	
	
	
	
	
		
}