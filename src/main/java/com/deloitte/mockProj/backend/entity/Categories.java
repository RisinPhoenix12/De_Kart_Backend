package com.deloitte.mockProj.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="categories", schema="de_kart")
public class Categories {
	
	@Id
	private String category;
	
	@Lob
	@Column(columnDefinition = "BLOB", name="category_image")
	private String category_image;

	public Categories() {
		super();
	}

	public Categories(String category, String category_image) {
		super();
		this.category = category;
		this.category_image = category_image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory_image() {
		return category_image;
	}

	public void setCategory_image(String category_image) {
		this.category_image = category_image;
	}

	@Override
	public String toString() {
		return "Categories [category=" + category + ", category_image=" + category_image + "]";
	}
	
	
}
