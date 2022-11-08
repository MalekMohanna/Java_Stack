package com.malek.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.malek.dojos.models.Ninja;
import com.malek.dojos.reposotaries.NinjaRepo;

@Service
public class NinjaService {
private final NinjaRepo ninjaRepo;
public NinjaService(NinjaRepo ninjaRepo) {
this.ninjaRepo=ninjaRepo;
}
public List<Ninja> allNinjas(){
	return ninjaRepo.findAll();
}
public void createNinja(Ninja ninja) {
	ninjaRepo.save(ninja);
}
public Ninja findNinja(Long id) {
	Optional<Ninja> optionalNinja= ninjaRepo.findById(id);
    if(optionalNinja.isPresent()) {
        return optionalNinja.get();
    } else {
        return null;
    }
}
public void deleteNinja(Long id) {
	ninjaRepo.deleteById(id);
}
public Ninja updateNinja(Long id,Ninja ninja) {
Ninja toUpdate= findNinja(id);
toUpdate.setAge(ninja.getAge());
toUpdate.setDojo(ninja.getDojo());
toUpdate.setFirstName(ninja.getFirstName());
toUpdate.setLastName(ninja.getLastName());
ninjaRepo.save(toUpdate);
	return null;
}
}
