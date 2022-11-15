package com.malek.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.malek.project.models.Project;
import com.malek.project.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>{
List<Project> findAll();
List<Project> findByUsersNotContains(User user);
List<Project> findByUsersContains(User user);
List<Project> findByTeamLeader(User user);
}
