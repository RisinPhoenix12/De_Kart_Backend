package com.deloitte.mockProj.backend.Services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deloitte.mockProj.backend.Repository.CategoryRepo;
import com.deloitte.mockProj.backend.entity.Categories;

@Service
public class CategoryService {

	@Autowired
	CategoryRepo categoryRepo;
	
	public void addCategoryService(String category, MultipartFile file) {
		
		Categories ctg = new Categories();
		
		ctg.setCategory(category);
		try {
			ctg.setCategory_image(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			System.out.println("There is error in category services while saving image");
			e.printStackTrace();
		}
		categoryRepo.save(ctg);
	}
	
	public List<Categories> getAllCategories() {
		return categoryRepo.findAll();
	}
}
