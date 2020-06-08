package com.prakash.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prakash.tm.model.Truck;
import com.prakash.tm.repository.TruckRepository;

@Service
public class TruckService {

	@Autowired
	private TruckRepository truckRepository;

	public Truck save(Truck truck) {
		return truckRepository.save(truck);
	}

	public Truck findById(String id) {
		return truckRepository.findById(id).orElse(null);
	}

	public void deleteById(String id) {
		 truckRepository.deleteById(id);

	}

	public List<Truck> list() {
		return truckRepository.findAll();
	}
}