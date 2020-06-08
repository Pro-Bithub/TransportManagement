package com.prakash.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prakash.tm.model.Transport;
import com.prakash.tm.repository.TransportRepository;

@Service
public class TransportService {

	@Autowired
	private TransportRepository transportRepository;

	public Transport save(Transport transport) {
		return transportRepository.save(transport);
	}

	public Transport findById(long id) {
		return transportRepository.findById(id).orElse(null);
	}

	public void deleteById(long id) {
		 transportRepository.deleteById(id);
	}

	public List<Transport> list() {
		return transportRepository.findAll();
	}
}