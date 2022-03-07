package com.belmar.javaredbeltexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belmar.javaredbeltexam.models.Show;
import com.belmar.javaredbeltexam.repositories.ShowRepository;


@Service
public class ShowService {
	
	@Autowired
	private ShowRepository showRepo;

	
	//show all Shows
	public List<Show> findAllShows(){
		//use the repo to query the idea table for all Shows
		return (List<Show>)this.showRepo.findAll();
	}
	
	
	//create Show
	public Show createNewShow(Show show) {
		return this.showRepo.save(show);
	}
	
	//get one Show
	public Show getOneShow(Long id) {
		return this.showRepo.findById(id).orElse(null);
	}
	
	//update one Show
	public Show updateShow(Show show) {
		return this.showRepo.save(show);
	}
	
	
	//delete one Show
	public void deleteShow(Long id) {
		this.showRepo.deleteById(id);
	}

}