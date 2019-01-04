package com.epam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
