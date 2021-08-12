package com.cg.osm.service;

import com.cg.osm.exception.OrderBillNotFoundException;
import com.cg.osm.entities.ProductCategory;
import com.cg.osm.entities.SweetOrder;
import com.cg.osm.entities.OrderBill;

import java.util.List;

import org.springframework.stereotype.Service;



@Service
public interface IOrderBillService {

	OrderBill fetchById(int OrderBillnumber) throws OrderBillNotFoundException;

	OrderBill addOrderBill(OrderBill OrderBill);

	void updateOrderBill(OrderBill OrderBill);

	void delOrderBill(int orderBillnumber) throws OrderBillNotFoundException;

	List<OrderBill> fetchAll();
}