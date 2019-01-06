package com.epam.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.CourseRepository;
import com.epam.dao.StudentDao;
import com.epam.entity.Course;
import com.epam.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	CourseRepository courseRepository;
	
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
	
	public List<Student> getStudents(){
		return studentDao.findAll();
	}

	public Student addStudent(Student student) {
		Set<Course> courses = student.getCourses();
		final Set<Course> attachedCourses = new HashSet();
		courses.forEach(course -> {
			Course courseResult = courseRepository.findByName(course.getName());
			if(courseResult!=null) {
				attachedCourses.add(courseResult);
			} else {
				attachedCourses.add(course);
			}
		});
		student.setCourses(attachedCourses);
		return studentDao.saveAndFlush(student);
	}
	
	public List<String> findCoursesById(Integer studentId) {
		Optional<Student> student = studentDao.findById(studentId);
		List<String> courseNames = null;
		if (student.isPresent()) {

			Set<Course> courses = student.get().getCourses();
			courseNames = courses.stream().map(course -> course.getName()).collect(Collectors.toList());

		}

		return courseNames;

	}
}
