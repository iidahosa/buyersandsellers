package com.bns.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
public class ProductToCartItem {
	 @GenericGenerator(
	            name = "ProducttoCartSequenceGenerator",
	            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	            parameters = {
	                    @Parameter(name = "sequence_name", value = "producttoCartSequence"),
	                    @Parameter(name = "initial_value", value = "1"),
	                    @Parameter(name = "increment_size", value = "1")
	            }
	    )
		@Id
	    @GeneratedValue(generator = "ProducttoCartSequenceGenerator")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="Product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="cart_item_id")
	private CartItem cartItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

}
