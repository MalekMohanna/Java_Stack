package com.malek.dojos.reposotaries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.malek.dojos.models.Ninja;
@Repository
public interface NinjaRepo extends CrudRepository<Ninja,Long>{
List<Ninja> findAll();
}
