/**
 * 
 */
package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.Student;
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

	@GetMapping(value="/allStudents")
	public List<Student> getAllStudent() {
		return studentService.getStudents();
	}
	
	
	@PostMapping(value="/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody Student student){ 
		Student id = studentService.addStudent(student);
		return ResponseEntity.ok(id.getId()+" success");
	}
	
	@GetMapping(value="/student/{id}/courses")
	public List<String> getCoursesByStudentId(@PathVariable Integer id) {
	return studentService.findCoursesById(id);	
	}
}