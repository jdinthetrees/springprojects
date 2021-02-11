package com.johndang.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johndang.relationships.models.License;

import com.johndang.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	@Autowired
	private LicenseRepository licenseRepository;
	
	//returns all the licenses
	public List<License> findAllLicenses() {
		return licenseRepository.findAll();
		}
	
	//get one license
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
			} else {
				return null;
				}
		}
	
//	creates a license
	public License createLicense(License license) {
		return licenseRepository.save(license);
	}
	

	
	
	//deletes a license
		public void deleteLicense(Long id) {
			licenseRepository.deleteById(id);
		}
    

}
