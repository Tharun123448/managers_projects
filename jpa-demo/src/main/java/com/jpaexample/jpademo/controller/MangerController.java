package com.jpaexample.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jpaexample.jpademo.dao.ManagerDaoServices;
import com.jpaexample.jpademo.entites.Manager;

@RestController
public class MangerController {
	
	@Autowired
	private ManagerDaoServices mds;

	@GetMapping(path = "/get_all_managers")
	public String getAllMangers() {
		String s = "";
		Manager m1 = new Manager("Deepthi", "Kolluru");
		Manager m2 = new Manager("Brajdeep", "Singh");
		Manager m3 = new Manager("Jhon", "Mathews");
		Manager m4 = new Manager("Manas", "Iyer");
		mds.save(m1);
		mds.save(m2);
		mds.save(m3);
		mds.save(m4);
		List<Manager> managersList = mds.findAll();
		for(Manager m : managersList) 
			s += m.getFirstName()+"-"+m.getManagerId()+" ";
		
		return s;
	}
	
	@GetMapping(path = "/find_manager/{firstName}")
	public String findMangers(@PathVariable(name = "firstName") String firstName) {
		//String s = "";
		Manager m1 = new Manager("Deepthi", "Kolluru");
		Manager m2 = new Manager("Brajdeep", "Singh");
		Manager m3 = new Manager("Jhon", "Mathews");
		Manager m4 = new Manager("Manas", "Iyer");
		mds.save(m1);
		mds.save(m2);
		mds.save(m3);
		mds.save(m4);
		Manager m = mds.findManagerByFirstName(firstName);
		
		return m.getFirstName()+" "+m.getLastName()+"-"+m.getManagerId();
	}
	
	@GetMapping(path = "/get_manager/{firstName}")
	public String getMangers(@PathVariable(name = "firstName") String firstName) {
		//String s = "";
		Manager m1 = new Manager("Deepthi", "Kolluru");
		Manager m2 = new Manager("Brajdeep", "Singh");
		Manager m3 = new Manager("Jhon", "Mathews");
		Manager m4 = new Manager("Manas", "Iyer");
		mds.save(m1);
		mds.save(m2);
		mds.save(m3);
		mds.save(m4);
		Manager m = mds.getManagerByFirstName(firstName);
		
		return m.getFirstName()+" "+m.getLastName()+"-"+m.getManagerId();
	}
		
}
