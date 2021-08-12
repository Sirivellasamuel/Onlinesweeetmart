package com.cg.osm.service;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.osm.exception.SweetOrderNotFoundException;
import com.cg.osm.entities.SweetOrder;
import com.cg.osm.repository.SweetOrderRepository;

@Service
public class SweetOrderServiceImpl implements ISweetOrderService {

	Logger logger = LoggerFactory.getLogger(SweetOrderServiceImpl.class);

	@Autowired
	private SweetOrderRepository repository;

	@Override
	public SweetOrder fetchById(int ordernumber) throws SweetOrderNotFoundException {
		Optional<SweetOrder> order = repository.findById(ordernumber);
		if (!order.isPresent())
			throw new SweetOrderNotFoundException();
		return order.get();
	}

	@Override
	public SweetOrder addSweetOrder(SweetOrder order) {
		logger.info("inside addOrder method of OrderServiceImpl");
		return repository.save(order);

	}

	@Override
	public void updateSweetOrder(SweetOrder order) {
		repository.save(order);
	}

	@Override
	public void delSweetOrder(int ordernumber) throws SweetOrderNotFoundException {
		Optional<SweetOrder> order = repository.findById(ordernumber);
		if (!order.isPresent())
			throw new SweetOrderNotFoundException();

		repository.deleteById(ordernumber);
	}

	@Override
	public List<SweetOrder> fetchAll() {
		return repository.findAll();
	}
}