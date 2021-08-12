package com.cg.osm.service;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.osm.exception.SweetItemNotFoundException;
import com.cg.osm.entities.SweetItem;
import com.cg.osm.repository.SweetItemRepository;

@Service
public class SweetItemServiceImpl implements ISweetItemService {

	Logger logger = LoggerFactory.getLogger(SweetItemServiceImpl.class);

	@Autowired
	private SweetItemRepository repository;

	@Override
	public SweetItem fetchById(int SweetItemnumber) throws SweetItemNotFoundException {
		Optional<SweetItem> SweetItem = repository.findById(SweetItemnumber);
		if (!SweetItem.isPresent())
			throw new SweetItemNotFoundException();
		return SweetItem.get();
	}

	@Override
	public SweetItem addSweetItem(SweetItem SweetItem) {
		logger.info("inside addSweetItem method of SweetItemServiceImpl");
		return repository.save(SweetItem);

	}

	@Override
	public void updateSweetItem(SweetItem SweetItem) {
		repository.save(SweetItem);
	}

	@Override
	public void delSweetItem(int SweetItemnumber) throws SweetItemNotFoundException {
		Optional<SweetItem> SweetItem = repository.findById(SweetItemnumber);
		if (!SweetItem.isPresent())
			throw new SweetItemNotFoundException();

		repository.deleteById(SweetItemnumber);
	}

	@Override
	public List<SweetItem> fetchAll() {
		return repository.findAll();
	}
}