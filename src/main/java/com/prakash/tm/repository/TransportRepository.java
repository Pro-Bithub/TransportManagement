package com.prakash.tm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prakash.tm.model.Transport;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {
}