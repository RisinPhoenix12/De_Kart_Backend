package com.deloitte.mockProj.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="products", schema="de_kart")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int product_id;
	
	@Column
	private int seller_id;
	
	@Column
	private String product_category;
	
	@Column
	private String product_name;
	
	@Lob
	@Column(columnDefinition = "BLOB", name="product_image")
	private String product_image;
	
	@Column
	private int product_price;
	
	@Column
	private int stock;

	public Product() {
		super();
	}

	public Product(int product_id, int seller_id, String product_category, String product_name, String product_image,
			int product_price, int stock) {
		super();
		this.product_id = product_id;
		this.seller_id = seller_id;
		this.product_category = product_category;
		this.product_name = product_name;
		this.product_image = product_image;
		this.product_price = product_price;
		this.stock = stock;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", seller_id=" + seller_id + ", product_category="
				+ product_category + ", product_name=" + product_name + ", product_image=" + product_image
				+ ", product_price=" + product_price + ", stock=" + stock + "]";
	}
	
	
}
