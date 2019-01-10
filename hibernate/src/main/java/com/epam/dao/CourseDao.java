package com.epam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.entity.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {

	

}
