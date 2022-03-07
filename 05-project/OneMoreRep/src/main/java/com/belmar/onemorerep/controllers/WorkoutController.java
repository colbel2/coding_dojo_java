package com.belmar.onemorerep.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.belmar.onemorerep.models.Exercise;
import com.belmar.onemorerep.models.ExerciseInfo;
import com.belmar.onemorerep.models.User;
import com.belmar.onemorerep.models.Workout;
import com.belmar.onemorerep.services.ExerciseInfoService;
import com.belmar.onemorerep.services.ExerciseService;
import com.belmar.onemorerep.services.UserService;
import com.belmar.onemorerep.services.WorkoutService;

@Controller
public class WorkoutController {
	@Autowired
    private WorkoutService workoutServ;
	@Autowired
	private ExerciseService exerciseServ;
	@Autowired
	private ExerciseInfoService exerciseInfoServ;
	@Autowired
	private UserService userServ;
	
	
	@RequestMapping("/workout/new")
	public String addNewWorkout(Model model, HttpSession session) {
		//we will render a create form in this method
		
		
		//pass in empty workout object to the form so the form can bind to it
		model.addAttribute("workout", new Workout());
		model.addAttribute("exercise", new Exercise());
		model.addAttribute("exerciseInfo", new ExerciseInfo());
		 
		
//		get the id of the logged in user using session
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		
		//pass info about the logged in user to the form so that we know who is the uploader of the workout;
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		
		return "addWorkout.jsp";
	}
	
	@PostMapping("/workout/create")
	public String createNewWorkout(@Valid @ModelAttribute Workout workout, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "addWorkout.jsp";
		}
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		
		User user = userServ.findOneUser(idOfLoggedInUser);
		
		//if the form is submitted properly and there are no validation errors, request the service to create something new( new idea)
		workout.setUploader(user);
		this.workoutServ.createNewWorkout(workout);
		
		if (workout.getExercises() != null)
		{
			for (Exercise exercise: workout.getExercises())
			{
				exercise.setExerciser(workout);
				exerciseServ.createExercise(exercise);
				if (exercise.getExerciseInfos() != null)
				{
					for(ExerciseInfo exerciseInfo: exercise.getExerciseInfos())
					{
						exerciseInfo.setExerciseInformer(exercise);
						exerciseInfoServ.createExerciseInfo(exerciseInfo);
					}
				}
			}
		}
		return "redirect:/home";
	}
	
	
	
	@RequestMapping("/workout/{id}/details")
	public String getWorkoutDetails(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		//use the id from the path variable to send to the service to get info about a workout given that id
		Workout workoutToShow = this.workoutServ.getOneWorkout(id);
		
		model.addAttribute("workoutToShow", workoutToShow);
		
		Exercise exerciseToShow = this.exerciseServ.getOneExercise(id);
		
//		get the id of the logged in user using session
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		
		//pass info about the logged in user to the form so that we know who is the uploader of the workout;
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		
		return "workoutDetail.jsp";
	}
	
	@RequestMapping("/workout/{id}/edit")
	public String editWorkout(@PathVariable("id")Long id, Model model, HttpSession session) {
		
		//get a workout from the db using the service and the id from the path
		Workout workout = this.workoutServ.getOneWorkout(id);
		
		model.addAttribute("workout", workout);
		
		
		//get the id of the logged in user using session
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		
		//pass info about the logged in user to the form so that we know who is the uploader of the workout
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		
			return "editWorkout.jsp";
		
		
		
		
	}
	
	@PutMapping("/workout/{id}/update")
	public String updateWorkout(@PathVariable("id") Long id, @Valid @ModelAttribute("workout") Workout workout, BindingResult result) {
		
		if(result.hasErrors()) {
			return "editWorkout.jsp";
		}
		
		//if no validation errors, send the workout object from the from to the service so the service can update it
		this.workoutServ.updateWorkout(workout);
		return "redirect:/home";
		
	}
	
	@RequestMapping("/workout/{id}/delete")
    public String deleteWorkout(@PathVariable("id") Long id) {
		
		this.workoutServ.deleteWorkout(id);
		
		return "redirect:/home";
	}
	
	
	
	
	
	
	
	
	
	
}
