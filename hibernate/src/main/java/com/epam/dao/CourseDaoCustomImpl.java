package com.epam.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.epam.entity.Course;

@Repository
public class CourseDaoCustomImpl implements CourseDaoCustom {

	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public Course findByName(final String courseName) {
		Query query = entityManager.createNativeQuery("SELECT c.* FROM course as c " +
                "WHERE c.name = ?", Course.class);
        query.setParameter(1, courseName );
        Course result = null;
        try {
        	result = (Course) query.getSingleResult();	
        } catch(NoResultException | NonUniqueResultException e){
        	
        }
        
        return result;
	}

}
