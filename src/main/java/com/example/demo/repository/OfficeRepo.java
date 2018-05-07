package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Office;

public interface OfficeRepo extends CrudRepository<Office, Long> {

}
