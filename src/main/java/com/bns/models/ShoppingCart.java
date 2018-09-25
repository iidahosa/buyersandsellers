package com.bns.models;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShoppingCart {
	 @GenericGenerator(
	            name = "ShoppingCartSequenceGenerator",
	            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	            parameters = {
	                    @Parameter(name = "sequence_name", value = "shoppingCartSequence"),
	                    @Parameter(name = "initial_value", value = "1"),
	                    @Parameter(name = "increment_size", value = "1")
	            }
	    )
		@Id
	    @GeneratedValue(generator = "ShoppingCartSequenceGenerator")
	private Long id;
	private BigDecimal GrandTotal;
	
	@OneToMany(mappedBy="shoppingCart", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<CartItem> cartItemList;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserAcc userAcc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getGrandTotal() {
		return GrandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		GrandTotal = grandTotal;
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public UserAcc getUserAcc() {
		return userAcc;
	}

	public void setUserAcc(UserAcc userAcc) {
		this.userAcc = userAcc;
	}


}
