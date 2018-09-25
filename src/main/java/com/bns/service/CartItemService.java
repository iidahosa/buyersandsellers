package com.bns.service;

import java.util.List;

import com.bns.models.Product;
import com.bns.models.CartItem;
import com.bns.models.Order;
import com.bns.models.ShoppingCart;
import com.bns.models.UserAcc;

public interface CartItemService {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	CartItem updateCartItem(CartItem cartItem);
	
	CartItem addProductToCartItem(Product product, UserAcc userAcc, int qty);
	
	CartItem findById(Long id);
	
	void removeCartItem(CartItem cartItem);
	
	CartItem save(CartItem cartItem);
	
	List<CartItem> findByOrder(Order order);
}
