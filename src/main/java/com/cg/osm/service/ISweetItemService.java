package com.cg.osm.service;

import com.cg.osm.exception.SweetItemNotFoundException;
import com.cg.osm.entities.ProductCategory;
import com.cg.osm.entities.SweetItem;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.osm.entities.SweetItem;

@Service
public interface ISweetItemService {

	SweetItem fetchById(int Sweetordernumber) throws SweetItemNotFoundException;

	SweetItem addSweetItem(SweetItem sweetItem);

	void updateSweetItem(SweetItem sweetItem);

	void delSweetItem(int SweetItemnumber) throws SweetItemNotFoundException;

	List<SweetItem> fetchAll();
}