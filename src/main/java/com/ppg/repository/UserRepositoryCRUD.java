package com.ppg.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ppg.domain.User;



@RepositoryRestResource
public interface UserRepositoryCRUD extends CrudRepository<User, String> { 

}