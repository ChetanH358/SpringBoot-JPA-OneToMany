package com.demo.one_to_many;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.one_to_many.entity.Address;
import com.demo.one_to_many.entity.Student;
import com.demo.one_to_many.repository.AddressRepository;
import com.demo.one_to_many.repository.StudentRepository;

@SpringBootTest
class DemoJpaOneToManyApplicationTests {

	@Autowired
	private StudentRepository std_repository;
	
	@Autowired
	private AddressRepository add_repository;

	@Test
	void saveDetails() {
		Student s_1 = new Student();
		s_1.setStdId(101);
		s_1.setStdName("chetan");
		s_1.setStdUSN("01FE19BCV415");

		Student s_2 = new Student();
		s_2.setStdId(102);
		s_2.setStdName("akash");
		s_2.setStdUSN("01FE19BCV419");

		Address a_1 = new Address();
		a_1.setAddressId(501);
		a_1.setStreet("265/874");
		a_1.setCountry("India");
		a_1.setCity("Delhi");

		Address a_2 = new Address();
		a_2.setAddressId(502);
		a_2.setStreet("270/890");
		a_2.setCountry("India");
		a_2.setCity("punjab");

		Address a_3 = new Address();
		a_3.setAddressId(503);
		a_3.setStreet("290/850");
		a_3.setCountry("India");
		a_3.setCity("haryana");

		Address a_4 = new Address();
		a_4.setAddressId(504);
		a_4.setStreet("300/450");
		a_4.setCountry("India");
		a_4.setCity("odisha");

		Set<Address> set_1 = new HashSet<Address>();
		set_1.add(a_1);
		set_1.add(a_2);

		Set<Address> set_2 = new HashSet<Address>();
		set_2.add(a_3);
		set_2.add(a_4);

		// student will be having the list of adresses
		s_1.setAddress(set_1);
		s_2.setAddress(set_2);

		// each address will be having corresponding student
		a_1.setStudent(s_1);
		a_2.setStudent(s_1);
		
		a_3.setStudent(s_2);
		a_4.setStudent(s_2);

		std_repository.saveAll(List.of(s_1, s_2));
	}
	
	@Test
	void DeleteStudent(){
		/*
		 *  trying to delete sudent but automatically all address coresponding
		 *  to that got deleted
		 */
		int id = 101;
		std_repository.deleteById(id);
	}
	
	@Test
	void DeleteAddress() {
		/*
		 * If we try to delete by id 503 then it will get the student id and 
		 * form student it will delete all the addresses corresponding to that 
		 * foreign key and finally it will delete the student as well
		 */
		
		int id = 503;	
		add_repository.deleteById(id);
	}
	
	@Test
	void DeleteExp() {
		/*
		 * 
		 */
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
