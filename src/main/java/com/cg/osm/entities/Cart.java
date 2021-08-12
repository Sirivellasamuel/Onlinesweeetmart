package com.cg.osm.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name = "Cart_tbl")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "cart_item")
	private String ListSweetItems;

	@Column(name = "SweetItemCount")
	private String sweetItemCount;

	@Column(name = "Total")
	private String total;
	
	@Column(name = "GrandTotal")
	private String grandTotal;


}