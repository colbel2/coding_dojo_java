package com.belmar.loginregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.validation.BindingResult;



import com.belmar.loginregistration.models.LoginUser;
import com.belmar.loginregistration.models.User;

import com.belmar.loginregistration.repositories.UserRepository;




@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	// TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
    	// TO-DO - Reject values or register if no errors:
        
        // Reject if email is taken (present in database)
    	Optional<User> potentialUser = this.userRepo.findByEmail(newUser.getEmail()); //check if the email of the object coming from the registration form matches any users email in the db. If the email matches, that means the email is taken!
    	
    	System.out.println("we got this far");
    	
    	if(potentialUser.isPresent()) {
    		
    		result.rejectValue("email", "EmailTaken", "This Email is taken! Try again.");
    	}

        // Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "NoMatchy", "Password must match Confirm Password!");
    	}
        
        // Return null if result has errors
    	if(result.hasErrors()) {  
    		return null;
    	}else { //if no errors after checking all the validations, then we can create a user.
    		
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		
    		//set the user objects password to be the hashed password
    		newUser.setPassword(hashed);
    		return this.userRepo.save(newUser);
    		
    		
    	}
    
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
    	
    		
    	
    		// Find user in the DB by email
    		Optional<User> potentialUser = this.userRepo.findByEmail(newLoginObject.getEmail());
        // Reject if NOT present
        //if the email was not found, create a custom validation error message 
    		if(!potentialUser.isPresent()) {
    			result.rejectValue("email", "NotFound", "This email does not exist. Who you?");
    		}else {
    			//else means they tried to login with an email that is found
    			if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
    				 // Reject if BCrypt password match fails (create a new validation error)
    			    result.rejectValue("password", "No Matchy", "Invalid Password!");
    			}

    		}
    		
    		// Return null if result has errors
    		if(result.hasErrors()) {
    			return null;
    		}else {
    			// Otherwise, return the user object
    			return potentialUser.get();
    		}
        
        
    }
    
    
   //find one user
    public User findUser(Long id) {
    	return this.userRepo.findById(id).orElse(null);
    }

}