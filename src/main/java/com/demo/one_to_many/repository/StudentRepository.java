package com.demo.one_to_many.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.one_to_many.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
