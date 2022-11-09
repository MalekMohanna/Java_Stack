package com.malek.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.malek.products.models.Category;
import com.malek.products.models.Product;
@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{
List<Category> findAll();
List<Category> findByProductsNotContains(Product b);
}
