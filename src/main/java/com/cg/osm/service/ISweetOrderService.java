package com.cg.osm.service;

import com.cg.osm.exception.SweetOrderNotFoundException;
import com.cg.osm.entities.ProductCategory;
import com.cg.osm.entities.SweetOrder;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.osm.entities.SweetOrder;

@Service
public interface ISweetOrderService {

	SweetOrder fetchById(int Sweetordernumber) throws SweetOrderNotFoundException;

	SweetOrder addSweetOrder(SweetOrder sweetOrder);

	void updateSweetOrder(SweetOrder sweetOrder);

	void delSweetOrder(int Sweetordernumber) throws SweetOrderNotFoundException;

	List<SweetOrder> fetchAll();
}