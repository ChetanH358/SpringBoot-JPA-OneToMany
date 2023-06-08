package com.demo.one_to_many.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.one_to_many.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}
