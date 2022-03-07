package com.belmar.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.belmar.bookclub.models.LoginUser;
import com.belmar.bookclub.models.User;
import com.belmar.bookclub.repositories.UserRepository;




@Service
public class UserService {
	@Autowired
    private UserRepository userRepo;
    

   
    public User register(User newUser, BindingResult result) {
    		
        if(this.userRepo.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        
        //this validation is to make sure the password and confirm password match
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        
        
        if(result.hasErrors()) {
            return null;
        } else {
        		
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser); //save the user object to database
        }
    }
    
    
    
    
    public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        
        // checking if we can find a user in the database who has the email that was typed in the login form
        Optional<User> potentialUser = this.userRepo.findByEmail(newLogin.getEmail());
        
        //if the user with the login email does not exist, then create a validation message saying the email is not found
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        //get the user object that was found from the db who has that email from the login form
        User user = potentialUser.get();
        
        //use bcrypt to check if the user object from db has a password that matched the one from the form 
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");//if the password does not match, create another validation error message
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
    
    
    public User findUser(Long id) {
    		return this.userRepo.findById(id).orElse(null);
    }
    
}