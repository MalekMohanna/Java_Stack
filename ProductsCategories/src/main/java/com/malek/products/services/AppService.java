package com.malek.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.malek.products.models.Category;
import com.malek.products.models.CategoryProduct;
import com.malek.products.models.Product;
import com.malek.products.repositories.CatProRepository;
import com.malek.products.repositories.CategoryRepository;
import com.malek.products.repositories.ProductRepository;

@Service
public class AppService {
private final ProductRepository productRepo;
private final CategoryRepository categoryRepo;
private final CatProRepository catProRepo;
public AppService(ProductRepository productRepo, CategoryRepository categoryRepo, CatProRepository catProRepo) {
	this.productRepo = productRepo;
	this.categoryRepo = categoryRepo;
	this.catProRepo = catProRepo;
}
public Product createProduct(Product product) {
	return productRepo.save(product);
}
public Category createCategory(Category category) {
	return categoryRepo.save(category);
}
public List<Product> allProducts() {
	return productRepo.findAll();
}
public List<Category> allCategorys() {
	return categoryRepo.findAll();
}
public Product findProduct(Long id) {
	return this.productRepo.findById(id).orElse(null);
}

public Category findCategory(Long id) {
	return this.categoryRepo.findById(id).orElse(null);
}


public Product updateProduct(Product b) {
	return this.productRepo.save(b);
	
}

public void updateCategory(Category auth) {
	categoryRepo.save(auth);
	
}

public List<Category> categorysNotInProduct(Product b){
	return categoryRepo.findByProductsNotContains(b);
}

public CategoryProduct createProductCategory(CategoryProduct ba) {
	return catProRepo.save(ba);
}

}
