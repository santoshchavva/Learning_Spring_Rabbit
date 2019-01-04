/**
 * 
 */
package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.service.CourseService;
import com.epam.service.StudentService;

/**
 * @author Santosh_Chavva
 *
 */
@RestController
public class StudentRestController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;

	@RequestMapping(value="/allStudents", method = RequestMethod.GET)
	public ResponseEntity<String> getAllStudent() {
		studentService.addStudents();
		//System.out.println(courseService.getStudentsByCourseName(""));
		return ResponseEntity.ok("Success");
	}
}
