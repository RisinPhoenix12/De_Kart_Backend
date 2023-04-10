package com.deloitte.mockProj.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.mockProj.backend.entity.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart,Integer>{

	/*
	 * @Query(value="update cart set cart_details = ?2 WHERE user_id = ?1",
	 * nativeQuery = true) void updateUsrCart(Integer id,String details);
	 */
	
}
