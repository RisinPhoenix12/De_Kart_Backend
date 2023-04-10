package com.deloitte.mockProj.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.mockProj.backend.Repository.CartDao;
import com.deloitte.mockProj.backend.entity.Cart;

@SuppressWarnings("deprecation")
@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao;

	public Cart getCart(Integer user_id) {
		Cart userCart= cartDao.findById(user_id).get();
		return userCart;
	}

	public void updateCart(String currCart, Integer user_id) {
		/*cartDao.updateUsrCart(user_id, currCart);*/
		
		Cart tobeChanged = cartDao.getOne(user_id);
		tobeChanged.setCart_details(currCart);
		cartDao.save(tobeChanged);
		
	}
}
