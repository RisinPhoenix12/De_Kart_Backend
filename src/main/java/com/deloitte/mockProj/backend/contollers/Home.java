package com.deloitte.mockProj.backend.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deloitte.mockProj.backend.Services.CartService;
import com.deloitte.mockProj.backend.Services.CategoryService;
import com.deloitte.mockProj.backend.Services.CustomUserDetailsService;
import com.deloitte.mockProj.backend.Services.ProductService;
import com.deloitte.mockProj.backend.entity.Cart;
import com.deloitte.mockProj.backend.entity.Categories;
import com.deloitte.mockProj.backend.entity.Product;
import com.deloitte.mockProj.backend.entity.User;

@RestController
@CrossOrigin(origins="*")
public class Home {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CustomUserDetailsService userService;
	
	
	//Cart Functionalities
		@GetMapping("/cart/getCart/{user_id}")
		private Cart getCartItems(@PathVariable Integer user_id) {
			Cart userCart = cartService.getCart(user_id);
			return userCart;
		}
		@PostMapping("/cart/updateCart/{user_id}")
		private void updateCartItems(@RequestBody String currCart, @PathVariable Integer user_id) {
			cartService.updateCart(currCart, user_id);
		}
		
	//Universal Store Functionalities
	
	  @GetMapping("/getCategories")
	  private List<Categories> getCategories() {
		  List<Categories> categories = categoryService.getAllCategories();
		  return categories;
	  }
	 
	  @GetMapping("/getAllProducts")
	  private List<Product> getAllProducts() {
		  List<Product> pdts = productService.getAllProductService();
		  return pdts;
	  }
		
	//Seller Functionalities
		@PostMapping("/seller/addCategory")
		private void addCategory(@RequestParam String category, @RequestParam MultipartFile file) {
			categoryService.addCategoryService(category, file);
		}
		
		@PostMapping("/seller/addProduct")
		private void addProduct(@RequestParam Integer seller_id, @RequestParam String product_category,
				@RequestParam String product_name, @RequestParam MultipartFile file, @RequestParam Integer product_price, @RequestParam Integer stock) {
			productService.addProductService(seller_id, product_category, product_name, file, product_price, stock);
		}
}
