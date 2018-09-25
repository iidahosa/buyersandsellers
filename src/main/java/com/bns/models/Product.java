package com.bns.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	 @GenericGenerator(
	            name = "ProductSequenceGenerator",
	            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	            parameters = {
	                    @Parameter(name = "sequence_name", value = "productSequence"),
	                    @Parameter(name = "initial_value", value = "1"),
	                    @Parameter(name = "increment_size", value = "1")
	            }
	    )
		@Id
	    @GeneratedValue(generator = "ProductSequenceGenerator")
	    private Long id;
		private String title;
		private String supplier;
		private String category;
		@Column(columnDefinition="NUMBER(19,4)")
		private double shippingWeight;
		@Column(columnDefinition="NUMBER(19,4)")
		private double listPrice;
		@Column(columnDefinition="NUMBER(19,4)")
		private double ourPrice;
		private boolean active=true;
		
		@Column(columnDefinition="CLOB")
		private String description;
		private int inStockNumber;

		@Transient
		private MultipartFile productImage;
		
		
		@OneToMany(mappedBy = "product")
		@JsonIgnore
		private List<ProductToCartItem> productToCartItemList;


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getSupplier() {
			return supplier;
		}


		public void setSupplier(String supplier) {
			this.supplier = supplier;
		}


		public String getCategory() {
			return category;
		}


		public void setCategory(String category) {
			this.category = category;
		}


		public double getShippingWeight() {
			return shippingWeight;
		}


		public void setShippingWeight(double shippingWeight) {
			this.shippingWeight = shippingWeight;
		}


		public double getListPrice() {
			return listPrice;
		}


		public void setListPrice(double listPrice) {
			this.listPrice = listPrice;
		}


		public double getOurPrice() {
			return ourPrice;
		}


		public void setOurPrice(double ourPrice) {
			this.ourPrice = ourPrice;
		}


		public boolean isActive() {
			return active;
		}


		public void setActive(boolean active) {
			this.active = active;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public int getInStockNumber() {
			return inStockNumber;
		}


		public void setInStockNumber(int inStockNumber) {
			this.inStockNumber = inStockNumber;
		}


		public MultipartFile getProductImage() {
			return productImage;
		}


		public void setProductImage(MultipartFile productImage) {
			this.productImage = productImage;
		}


		public List<ProductToCartItem> getProductToCartItemList() {
			return productToCartItemList;
		}


		public void setProductToCartItemList(List<ProductToCartItem> productToCartItemList) {
			this.productToCartItemList = productToCartItemList;
		}
		
		

}
