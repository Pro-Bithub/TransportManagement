package com.prakash.tm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prakash.tm.model.Truck;

@Repository
public interface TruckRepository extends JpaRepository<Truck, String> {
}