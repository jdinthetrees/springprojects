package com.johndang.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johndang.dojosandninjas.models.Ninja;
import com.johndang.dojosandninjas.repos.NinjaRepo;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepo ninjaRepo; 
	
	
	//get all
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	//find by Id
	public Ninja findById(Long id) {
		Optional<Ninja> ninja = ninjaRepo.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		}else {
			return null;
		}
	}
	
	//create and update
	public Ninja save(Ninja ninja) {
		return ninjaRepo.save(ninja);
		
	}
	//delete
	public void delete(Long id) {
		ninjaRepo.deleteById(id);
	}

}

