package com.prakash.tm;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.prakash.tm.model.Driver;
import com.prakash.tm.model.Product;
import com.prakash.tm.model.Transport;
import com.prakash.tm.model.Truck;
import com.prakash.tm.repository.DriverRepository;
import com.prakash.tm.repository.ProductRepository;
import com.prakash.tm.repository.TransportRepository;
import com.prakash.tm.repository.TruckRepository;

@Transactional
@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private TruckRepository truckRepository;
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private TransportRepository transportRepository;

	@Override
	public void run(String... args) throws Exception {
		/*
		productRepository.deleteAll();
		truckRepository.deleteAll();
		driverRepository.deleteAll();
		transportRepository.deleteAll();
		
		Product p1 = productRepository.save(new Product(1l, "iPhone X", 1500d, true));
        Product p2 = productRepository.save(new Product(2l, "Samsung Galaxy 9", 800d, true));
        Product p3 = productRepository.save(new Product(3l, "iPad Pro", 3500d, true));
        Product p4 = productRepository.save(new Product(4l, "Asus Strix 2", 5300d, true));
        Product p5 = productRepository.save(new Product(5l, "Acer Helios", 1600d, true));
        
        Truck t1 = truckRepository.save(new Truck("123ABC456", "Ford", 1.5d, 8d, null, true));
        Truck t2 = truckRepository.save(new Truck("123XYZ456", "Mercedez", 2.1d, 7.8d, null, true));
        Truck t3 = truckRepository.save(new Truck("111PQR222", "Toyota", 1.8d, 6.8d, null, true));
        Truck t4 = truckRepository.save(new Truck("333STU444", "Tata", 1.3d, 7.5d, null, true));
        Truck t5 = truckRepository.save(new Truck("456WXY123", "Mercedez", 2.4d, 8d, null, true));
        
        Driver d1 = driverRepository.save(new Driver(10l, "John", "William", "1234567890", null, true));
        Driver d2 = driverRepository.save(new Driver(11l, "Steven", "Pattric", "9876543210", null, true));
        Driver d3 = driverRepository.save(new Driver(12l, "Michael", "Clarke", "4561237890", null, true));
        
        transportRepository.save(new Transport(20l, t1, d1, new Date(), "Mexico", 6d, 6d, true));
        transportRepository.save(new Transport(21l, t2, d2, new Date(), "USA", 5d, 4.8d, true));
        transportRepository.save(new Transport(22l, t5, d3, new Date(), "England", 7d, 7.9d, true));
        */
		
		System.out.println(productRepository.findAll());
		System.out.println(truckRepository.findAll());
		System.out.println(driverRepository.findAll());
		System.out.println(transportRepository.findAll());
	}
}