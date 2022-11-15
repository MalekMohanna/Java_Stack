package com.malek.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.malek.project.models.UserProject;

@Repository
public interface UpRepository extends CrudRepository<UserProject,Long>{
List<UserProject> findAll();

}
