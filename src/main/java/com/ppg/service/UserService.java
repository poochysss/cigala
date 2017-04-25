package com.ppg.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.ppg.domain.User;
import com.ppg.repository.UserRepository;

@Service
public class UserService {
		private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

		private UserRepository userRepository;

		@Autowired
		public void setUserRepository(UserRepository userRepository) {
			this.userRepository = userRepository;
		}

		public boolean deleteUser(String idUser) {
			return userRepository.deleteUser(idUser);
		}

		public boolean createUser(User user) {
			return userRepository.createUser(user);
		}
		
		public List<User> getUsers() {
			return userRepository.findAll();
		}

	
}
