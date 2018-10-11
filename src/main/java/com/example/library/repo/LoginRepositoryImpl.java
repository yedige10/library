package com.example.library.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.example.library.model.User;

public class LoginRepositoryImpl implements LoginRepository{
	@PersistenceContext
    EntityManager entityManager;

	@SuppressWarnings("unchecked")
	
	public User login(User user) {
        Query query = entityManager.createNativeQuery("SELECT * FROM user where username=? and password=?",User.class);
        query.setParameter(1, user.getUsername());
        query.setParameter(2, user.getPassword());
        return (User) query.getSingleResult();
	}
}
