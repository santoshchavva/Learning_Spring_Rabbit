package com.epam.dao;

import com.epam.entity.Course;

public interface CourseDaoCustom {

	Course findByName(final String courseName);
}
