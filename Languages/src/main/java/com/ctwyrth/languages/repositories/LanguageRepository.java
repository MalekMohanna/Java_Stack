package com.ctwyrth.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ctwyrth.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
    // this method retrieves all from the database
    List<Language> findAll(); 

} 