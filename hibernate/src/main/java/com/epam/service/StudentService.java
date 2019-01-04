package com.epam.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.StudentDao;
import com.epam.entity.Course;
import com.epam.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	public void addStudents() {
		
		Student student = new Student();
		student.setId(2);
		student.setName("Student Name");
		
		Course course = new Course();
		course.setId(1);
		course.setName("Course1");
		Set<Course> courses = new HashSet();
		courses.add(course);
		student.setCourses(courses);
		studentDao.save(student);
		
	}

}
