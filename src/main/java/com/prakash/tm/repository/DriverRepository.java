package com.prakash.tm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prakash.tm.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}