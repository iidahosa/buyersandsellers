package com.bns.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bns.models.CartItem;
import com.bns.models.Product;
import com.bns.models.ShoppingCart;
import com.bns.models.UserAcc;
import com.bns.service.ProductService;
import com.bns.service.CartItemService;
import com.bns.service.ShoppingCartService;
import com.bns.service.UserService;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping("/cart")
	public String shoppingCart(Model model, Principal principal) {
		UserAcc user = userService.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		shoppingCartService.updateShoppingCart(shoppingCart);
		
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart", shoppingCart);
		
		return "shoppingCart";
	}

	@RequestMapping("/addItem")
	public String addItem(
			@ModelAttribute("product") Optional<Product> product,
			@ModelAttribute("qty") String qty,
			Model model, Principal principal
			) {
		UserAcc user = userService.findByUsername(principal.getName());
		product = productService.findOne(product.get().getId());
		
		if (Integer.parseInt(qty) > product.get().getInStockNumber()) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/productDetail?id="+product.get().getId();
		}
		
		CartItem cartItem = cartItemService.addProductToCartItem(product.get(), user, Integer.parseInt(qty));
		model.addAttribute("addBookSuccess", true);
		
		return "forward:/productDetail?id="+product.get().getId();
	}
	
	@RequestMapping("/updateCartItem")
	public String updateShoppingCart(
			@ModelAttribute("id") Long cartItemId,
			@ModelAttribute("qty") int qty
			) {
		Optional<CartItem> cartItem = cartItemService.findById(cartItemId);
		cartItem.get().setQty(qty);
		cartItemService.updateCartItem(cartItem.get());
		
		return "forward:/shoppingCart/cart";
	}
	
	@RequestMapping("/removeItem")
	public String removeItem(@RequestParam("id") Long id) {
		cartItemService.removeCartItem(cartItemService.findById(id));
		
		return "forward:/shoppingCart/cart";
	}
}
