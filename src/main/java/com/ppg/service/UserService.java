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
		public void setAlarmRepository(UserRepository userRepository) {
			this.userRepository = userRepository;
		}

		public boolean deleteUser(String idUser) {
			return userRepository.deleteUser(idUser);
		}

		public boolean createUser(MultiValueMap<String, String> requestParams) {
			User alarm = new User();
			try {
//				alarm.setIdExecution(getParam(requestParams, "idExecution"));
//				alarm.setEmail(getParam(requestParams, "email"));
//				alarm.setTypes(getParamList(requestParams, "types"));
//				alarm.setStrategyName(getParam(requestParams, "strategyName"));
			} catch (IllegalArgumentException e) {
				LOGGER.error(e.getMessage(), e);
				return false;
			}
			return userRepository.createUser(alarm);
		}

		public String getParam(MultiValueMap<String, String> requestParams, String param) throws IllegalArgumentException {
			String value = requestParams.getFirst(param);
			if (value == null) {
				throw new IllegalArgumentException("Illegal argument " + requestParams.getFirst(param));
			}
			return value;
		}

		public List<String> getParamList(MultiValueMap<String, String> requestParams, String param) throws IllegalArgumentException {
			List<String> statusList;
			try {
				String paramValue = requestParams.getFirst(param);
				statusList = Arrays.asList(paramValue.substring(1, paramValue.length() - 1).split(", "));
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
				throw new IllegalArgumentException("Illegal list argument " + requestParams.get(param));
			}
			return statusList;
		}

	
		

	
	
	
	
	
	
	
	
	
	
	
}
