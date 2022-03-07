package com.belmar.mealclub.controllers;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.belmar.mealclub.models.LoginUser;
import com.belmar.mealclub.models.Book;
import com.belmar.mealclub.models.User;
import com.belmar.mealclub.services.BookService;
import com.belmar.mealclub.services.UserService;

@Controller
public class HomeController {
	
	private static final Object allBooks = null;

	@Autowired
	private UserService userServ;
	
	@Autowired
	private BookService bookServ;
	
	
//	@GetMapping("/")
//	public String index() {
//		return "index.jsp";
//	}
	
	@GetMapping("/")
    public String index(Model model) {
		
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        
        return "index.jsp";
    }
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
		
		//we are sending the model that was filled out from the form (containing username, email, pw, and confirm) to the service for additional validations
        this.userServ.register(newUser, result);
        
        
        
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/home";
    }
	
	
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
		
        User user = this.userServ.login(newLogin, result); //the service method login will either return null if there are validation errors, or it will return a whole user object from the db that the user is trying to log in as
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/home";
    }
	
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		Long loggedInUserId = (Long)session.getAttribute("user_id");
		System.out.println("PRINTING THE LOGGED IN USER ID!!!");
		System.out.println(loggedInUserId);
		
		if(loggedInUserId == null) {
			//generate a flash message to show on the redirect
			redirectAttributes.addFlashAttribute("notAllowed", "You must log in first!");
			return "redirect:/";
		}
		
		//use the id from session to find a user in our database that has that id, so we can pass that user to the template 
		User loggedInUser = this.userServ.findUser(loggedInUserId);
//		System.out.println(loggedInUser);
		model.addAttribute("loggedInUser", loggedInUser);
		
		
		//ask the service to get all the books and put it in a variable
		List<Book> allbooks = this.bookServ.findAllBooks();
		
		//pass that variable to the template
		model.addAttribute("allBooks", allBooks);
		
		return "home.jsp";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		return "redirect:/";
	}
	
	
	
	
	
	//show form to create a new book with
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		
		return "newBook.jsp";
	}
	
	//form submits to this route to create a new book object
	@PostMapping("/books/create")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		}
		
		
		System.out.println(book.getName());
		System.out.println(book.getDescription());
		System.out.println(book.getUploader());
		
		//get the logged in user. first the id of the logged in user is in session, so lets get that (use session!!)
		Long idOfLoggedInUser = (Long)session.getAttribute("user_id");
		
		//after we have the id of the logged in user, we can get the whole logged in user object using that id
		User loggedInUserObj = this.userServ.findUser(idOfLoggedInUser);
		
		
		//set the books uploader to be that loggedin user object
		book.setUploader(loggedInUserObj);
		

		this.bookServ.createBook(book);
		
		
		
		return "redirect:/home";
	}
	
	@GetMapping("/book/info/{id}")
	public String showBookInfo(@PathVariable("id")Long id, Model model) {
		//get a book from the db using the service
		Book bookobj = this.bookServ.getBook(id);
		//pass the book object to the templates
		model.addAttribute("bookobj",bookobj);
		
		
		return "bookinfo.jsp";
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	 

}
