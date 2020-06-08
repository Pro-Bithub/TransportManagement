package com.prakash.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prakash.tm.model.Driver;
import com.prakash.tm.repository.DriverRepository;

@Service
public class DriverService {

	@Autowired
	private DriverRepository driverRepository;

	public Driver save(Driver driver) {
		return driverRepository.save(driver);
	}

	public Driver findById(long id) {
		return driverRepository.findById(id).orElse(null);
	}

	public void deleteById(long id) {
		 driverRepository.deleteById(id);
	}

	public List<Driver> list() {
		return driverRepository.findAll();
	}
}