package com.bns.service;

import java.util.List;
import java.util.Optional;

import com.bns.models.Product;
import com.bns.models.CartItem;
import com.bns.models.Order;
import com.bns.models.ShoppingCart;
import com.bns.models.UserAcc;

public interface CartItemService {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	CartItem updateCartItem(CartItem cartItem);
	
	CartItem addProductToCartItem(Product product, UserAcc userAcc, int qty);
	
	Optional<CartItem> findById(Long id);
	
	void removeCartItem(Optional<CartItem> optional);
	
	CartItem save(CartItem cartItem);
	
	List<CartItem> findByOrder(Optional<Order> order);
}
