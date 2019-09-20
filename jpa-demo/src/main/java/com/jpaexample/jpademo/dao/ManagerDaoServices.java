package com.jpaexample.jpademo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpaexample.jpademo.entites.Manager;

@Repository
public interface ManagerDaoServices extends JpaRepository<Manager, Integer>{
	
	Manager findManagerByFirstName(String firstName);
	Manager getManagerByFirstName(String firstName);
}
