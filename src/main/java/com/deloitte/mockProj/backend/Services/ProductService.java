package com.deloitte.mockProj.backend.Services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deloitte.mockProj.backend.Repository.ProductRepo;
import com.deloitte.mockProj.backend.entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;

	public void addProductService(Integer seller_id, String product_category, String product_name
			, MultipartFile file, Integer product_price, Integer stock ) {

		Product pdt = new Product();

		pdt.setSeller_id(seller_id);
		pdt.setProduct_category(product_category);
		pdt.setProduct_name(product_name);
		pdt.setProduct_price(product_price);
		pdt.setStock(stock);
		try {
			pdt.setProduct_image(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			System.out.println("There is error in category services while saving image");
			e.printStackTrace();
		}
		productRepo.save(pdt);
	}
	
	public List<Product> getAllProductService() {
		return productRepo.findAll();
	}
}
