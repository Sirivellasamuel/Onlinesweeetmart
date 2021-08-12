
	
//	public Cart addCart(Cart Cart);
//	
//	public Cart updateCart(Cart Cart) throws CartNotFoundException;
//	
//	public Cart cancelCart(int CartId) throws CartNotFoundException;
//	
//	public List<Cart> showAllCarts();
//	
//	public List<Cart> showAllCarts(int cartdId);

	package com.cg.osm.service;

	import com.cg.osm.exception.CartNotFoundException;

	import java.util.List;

	import org.springframework.stereotype.Service;

	import com.cg.osm.entities.Cart;

	@Service
	public interface ICartService {

		
		
		Cart fetchById(int id) throws CartNotFoundException;
		
		
		Cart addCart(Cart cart);
		
		
		void  updateCart(Cart cart);
		
		
		void delCart(int id) throws CartNotFoundException;
		
		
		List<Cart> fetchAll();
	}

