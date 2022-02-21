package com.belmar.loginregistration.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.belmar.loginregistration.models.Book;
import com.belmar.loginregistration.models.LoginUser;
import com.belmar.loginregistration.models.User;
import com.belmar.loginregistration.services.BookService;
import com.belmar.loginregistration.services.UserService;



@Controller
public class HomeController {
	
     @Autowired
     private UserService userServ;
    
     @Autowired
     private BookService bookServ;
     
     
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
       
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
       
    	User user = this.userServ.register(newUser, result); 
        if(result.hasErrors()) {
         
            // re-rendering the page so the login form still has an empty object to bind to
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
       
      
        session.setAttribute("loggedInUserID", user.getId());
    
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
       
         User user = userServ.login(newLogin, result); 
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User()); 
            return "index.jsp";
        }
    
       
        session.setAttribute("loggedInUserID", user.getId());
    
        return "redirect:/home";
    }
    
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    		Long id = (Long) session.getAttribute("loggedInUserID"); //this gives the id of the user stored in session (logged in user's id)
    		
    		
    		System.out.println("id of logged in user " + id);
    		
    		if(id == null) { //if they are not logged in and trying to view the dashboard, redirect to the login reg form
    			return "redirect:/";
    		}
    		//get the user object with the id from session using the service
    		User loggedInUser = this.userServ.findUser(id);
    		
    		model.addAttribute("loggedInUser", loggedInUser);
    		
    		List<Book> allBooks = this.bookServ.findAllBooks();
    		model.addAttribute("allBooks", allBooks);
    		return "dashboard.jsp";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    		session.invalidate(); //clear out the session so it doesnt store the user as logged in anymore
    		
    		return "redirect:/";
    }
    
  //add a book
  	@GetMapping("/book/add")
  	public String addbook(@ModelAttribute("book") Book book) {
  		
  		
  		return"addbook.jsp";
  	}
  	
  	
  	//create a book when the form is submitted
  	@PostMapping("/book/create")
  	public String createBook(@Valid @ModelAttribute("book")Book book, BindingResult result, HttpSession session) {
  		
  		if(result.hasErrors()) {
  			return "addbook.jsp";
  		}
  		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
  		
  		User loggedInUserObj = this.userServ.findUser(idOfLoggedInUser);
  		
  		book.setPostedBy(loggedInUserObj);
  		
  		this.bookServ.createBook(book);
  		
  		return "redirect:/home";
  		
  		}
  		
  	

  	 //get one book by id
  	@GetMapping("/book/{id}")
    public String showOneBook(@PathVariable("id")Long id, Model model) {
    	Book bookObj = this.bookServ.getBook(id);
    	model.addAttribute("bookObj", bookObj);
    	return "onebookdetails.jsp";
    }

    
}