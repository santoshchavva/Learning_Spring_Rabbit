/**
 * 
 */
package com.epam.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.CourseDao;
import com.epam.entity.Course;
import com.epam.entity.Student;

/**
 * @author Santosh_Chavva
 *
 */
@Service
public class CourseService {
	
	@Autowired
	CourseDao courseDao;
	
	public Set<Student> getStudentsByCourseName(final String courseName){
		Course result = courseDao.getOne(1);
		return result.getStudents();
	}

}
