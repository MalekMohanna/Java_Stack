package com.malek.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.malek.dojos.models.Dojo;
import com.malek.dojos.reposotaries.DojoRepo;

@Service
public class DojoService {
private final DojoRepo dojorepo;
public DojoService(DojoRepo dojorepo) {
	this.dojorepo=dojorepo;
}
public List<Dojo> allDojos(){
	return dojorepo.findAll();
}
public void createDojo(Dojo dojo) {
	dojorepo.save(dojo);
}
public Dojo findDojo(Long id) {
	Optional<Dojo> optionalDojo= dojorepo.findById(id);
    if(optionalDojo.isPresent()) {
        return optionalDojo.get();
    } else {
        return null;
    }
}
public void deleteDojo(Long id) {
	dojorepo.deleteById(id);
}
public Dojo updateDojo(Long id,Dojo dojo) {
Dojo toUpdate= findDojo(id);
toUpdate.setName(dojo.getName());
dojorepo.save(toUpdate);
	return null;
}
}
