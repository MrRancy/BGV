package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.entity.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {

}
