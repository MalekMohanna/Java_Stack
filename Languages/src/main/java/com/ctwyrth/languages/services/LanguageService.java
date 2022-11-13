package com.ctwyrth.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctwyrth.languages.models.Language;
import com.ctwyrth.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;
    
    // shows all
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
	
    // creates one
    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
    // retrieves one by id
    public Language findLanguage(Long id) {
    	Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    // updates one
    public Language updateLanguage(Language l) {
       	return languageRepository.save(l);
    }
    
    // deletes one
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }
}