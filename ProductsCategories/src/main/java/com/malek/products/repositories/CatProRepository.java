package com.malek.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.malek.products.models.CategoryProduct;
@Repository
public interface CatProRepository extends CrudRepository<CategoryProduct,Long>{
List<CategoryProduct> findAll();
}
