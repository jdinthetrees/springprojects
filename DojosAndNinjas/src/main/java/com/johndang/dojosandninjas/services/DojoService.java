package com.johndang.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johndang.dojosandninjas.models.Dojo;
import com.johndang.dojosandninjas.repos.DojoRepo;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepo dojoRepo; 
	
	
	//get all
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	//find by Id
	public Dojo findById(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}else {
			return null;
		}
	}
	
	//create and update
	public Dojo save(Dojo dojo) {
		return dojoRepo.save(dojo);
		
	}
	//delete
	public void delete(Long id) {
		dojoRepo.deleteById(id);
	}

}
