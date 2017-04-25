package com.ppg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppg.domain.User;
import com.ppg.service.UserService;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserRepository(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
//    	User user = new User();
//    	user.setUsername("lalal");
//    	user.setPassword("lala");
//    	userService.createUser(user);
//        return "User Created";
        return "Wellcome to the authentication server!";
    }

    @RequestMapping("user/list")
    @ResponseBody   
    public List<User> listall(){
        return userService.getUsers();
    }
 

    @RequestMapping("user/add/{username}/{password}")
    @ResponseBody   
    public String createuser(@PathVariable String username,@PathVariable String password){
    	User user = new User();
    	user.setUsername(username);
    	user.setEmail(username);
    	user.setPassword(password);
    	userService.createUser(user);
        return "User Created";
    }
    

    
    @RequestMapping("user/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable String id){
    	userService.deleteUser(id);
        return "User Deleted";
    }
    
    

}
