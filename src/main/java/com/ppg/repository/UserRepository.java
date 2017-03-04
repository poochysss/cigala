package com.ppg.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ppg.domain.User;


@Repository
public class UserRepository {

	@PersistenceContext
	public EntityManager entityManager;
	
	
	
    @Query
	public
    User findByUsernameCaseInsensitive(@Param("username") String username){
    	return (User) entityManager.createQuery("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)").setParameter("username", username).getSingleResult();
    }

    @Query
	public
    User findByEmail(@Param("email") String email){
    	return (User) entityManager.createQuery("SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email)").setParameter("email", email).getSingleResult();

    }

    @Query
    User findByEmailAndActivationKey(@Param("email") String email, @Param("activationKey") String activationKey){
    	return (User) entityManager.createQuery("SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email)  AND LOWER(u.activationKey) = LOWER(:activationKey) ").setParameter("email", email).setParameter("activationKey", activationKey).getSingleResult();

    }

    @Query
    User findByEmailAndResetPasswordKey(@Param("email") String email,@Param("resetPasswordKey") String resetPasswordKey){
    	return (User) entityManager.createQuery("SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email)  AND LOWER(u.resetPasswordKey) = LOWER(:resetPasswordKey) ").getSingleResult();

    }

    
	@Transactional
	public
	boolean createUser(User user) {
		try {
			entityManager.persist(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean deleteUser(String idUser) {
		try {
			List<?> alarms = entityManager
					.createQuery("select a from User a where a.idUser = :idUser")
					.setParameter("idUser", idUser)
					.getResultList();
			if (!alarms.isEmpty()) {
				User alarm = (User) alarms.get(0);
				entityManager.remove(alarm);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}