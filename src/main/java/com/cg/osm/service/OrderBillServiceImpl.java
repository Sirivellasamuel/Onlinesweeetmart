package com.cg.osm.service;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.osm.exception.OrderBillNotFoundException;
import com.cg.osm.entities.OrderBill;
import com.cg.osm.repository.OrderBillRepository;

@Service
public class OrderBillServiceImpl implements IOrderBillService {

	Logger logger = LoggerFactory.getLogger(OrderBillServiceImpl.class);

	@Autowired
	private OrderBillRepository repository;

	@Override
	public OrderBill fetchById(int orderBillnumber) throws OrderBillNotFoundException {
		Optional<OrderBill> orderBill = repository.findById(orderBillnumber);
		if (!orderBill.isPresent())
			throw new OrderBillNotFoundException();
		return orderBill.get();
	}

	@Override
	public OrderBill addOrderBill(OrderBill orderBill) {
		logger.info("inside addOrder method of OrderBillServiceImpl");
		return repository.save(orderBill);

	}

	@Override
	public void updateOrderBill(OrderBill orderBill) {
		repository.save(orderBill);
	}

	@Override
	public void delOrderBill(int orderBillnumber) throws OrderBillNotFoundException {
		Optional<OrderBill> orderBill = repository.findById(orderBillnumber);
		if (!orderBill.isPresent())
			throw new OrderBillNotFoundException();

		repository.deleteById(orderBillnumber);
	}

	@Override
	public List<OrderBill> fetchAll() {
		return repository.findAll();
	}
}