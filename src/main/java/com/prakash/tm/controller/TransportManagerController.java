package com.prakash.tm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prakash.tm.exception.EmailAlreadyExistsException;
import com.prakash.tm.exception.UsernameAlreadyExistsException;
import com.prakash.tm.model.Driver;
import com.prakash.tm.model.Product;
import com.prakash.tm.model.Transport;
import com.prakash.tm.model.Truck;
import com.prakash.tm.model.User;
import com.prakash.tm.service.DriverService;
import com.prakash.tm.service.ProductService;
import com.prakash.tm.service.TransportService;
import com.prakash.tm.service.TruckService;
import com.prakash.tm.service.UserService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class TransportManagerController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;
	@Autowired
	private TruckService truckService;
	@Autowired
	private DriverService driverService;
	@Autowired
	private TransportService transportService;

	@GetMapping("/authenticate")
	public ResponseEntity<String> authenticate() {
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<User> register(@Valid @RequestBody User newUser) {

		User user = userService.findUserByEmail(newUser.getEmail());
		if (user != null) {
			throw new EmailAlreadyExistsException(
					"Email address \"" + newUser.getEmail() + "\" is already registered.");
		}
		user = userService.findUserByUserName(newUser.getUserName());
		if (user != null) {
			throw new UsernameAlreadyExistsException("Username \"" + newUser.getUserName() + "\" is already taken.");
		}
		return new ResponseEntity<User>(userService.saveUser(newUser), HttpStatus.OK);
	}
	// modified by ghozzi start

	@PostMapping("/products/save")
	public ResponseEntity<Product> newproduct(@Valid @RequestBody Product newproduct) {

		return new ResponseEntity<Product>(productService.save(newproduct), HttpStatus.OK);
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> products() {
		return new ResponseEntity<List<Product>>(productService.list(), HttpStatus.OK);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> productget(@PathVariable("id") long id) {
		return new ResponseEntity<Product>(productService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/product/remove/{id}")
	public ResponseEntity<String> productremove(@PathVariable("id") long id) {
		productService.deleteById(id);
		return new ResponseEntity<String>("done ! remove product ", HttpStatus.OK);
	}

	@PostMapping("/trucks/save")
	public ResponseEntity<Truck> newtruck(@Valid @RequestBody Truck newtruck) {

		return new ResponseEntity<Truck>(truckService.save(newtruck), HttpStatus.OK);
	}

	@GetMapping("/trucks")
	public ResponseEntity<List<Truck>> trucks() {
		return new ResponseEntity<List<Truck>>(truckService.list(), HttpStatus.OK);
	}

	@GetMapping("/truck/{id}")
	public ResponseEntity<Truck> Truckget(@PathVariable("id") String id) {
		return new ResponseEntity<Truck>(truckService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/truck/remove/{id}")
	public ResponseEntity<String> truckremove(@PathVariable("id") String id) {
		truckService.deleteById(id);
		return new ResponseEntity<String>("done ! remove truck ", HttpStatus.OK);
	}

	@PostMapping("/driver/save")
	public ResponseEntity<Driver> newDriver(@Valid @RequestBody Driver newDriver) {

		return new ResponseEntity<Driver>(driverService.save(newDriver), HttpStatus.OK);
	}

	@GetMapping("/driver/{id}")
	public ResponseEntity<Driver> Driverget(@PathVariable("id") long id) {
		return new ResponseEntity<Driver>(driverService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/drivers")
	public ResponseEntity<List<Driver>> drivers() {
		return new ResponseEntity<List<Driver>>(driverService.list(), HttpStatus.OK);
	}

	@GetMapping("/driver/remove/{id}")
	public ResponseEntity<String> driverremove(@PathVariable("id") long id) {
		driverService.deleteById(id);
		return new ResponseEntity<String>("done ! remove truck ", HttpStatus.OK);
	}

	@PostMapping("/transports/save")
	public ResponseEntity<Transport> newTransport(@Valid @RequestBody Transport newTransport) {

		return new ResponseEntity<Transport>(transportService.save(newTransport), HttpStatus.OK);
	}

	@GetMapping("/transports")
	public ResponseEntity<List<Transport>> transports() {
		return new ResponseEntity<List<Transport>>(transportService.list(), HttpStatus.OK);
	}

	@GetMapping("/transports/{id}")
	public ResponseEntity<Transport> Transportget(@PathVariable("id") long id) {
		return new ResponseEntity<Transport>(transportService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/transport/remove/{id}")
	public ResponseEntity<String> transportremove(@PathVariable("id") long id) {
		transportService.deleteById(id);
		return new ResponseEntity<String>("done ! remove transport ", HttpStatus.OK);
	}
	// modified by ghozzi end
}
