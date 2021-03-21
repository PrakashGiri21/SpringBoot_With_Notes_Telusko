package com.telusko.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.dao.AlienRepo;
import com.telusko.demo.model.Alien;

/*@Controller*/
@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam("aid") int aid) {
		
		System.out.println(repo.findByTech("Java"));
		System.out.println(repo.findByAidGreaterThan(102));
		System.out.println(repo.findByTechSorted("Java"));
		
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;
	}
	
	@RequestMapping("/updateAlien")
	public String updateAlien(Alien alien) {
		repo.save(alien);
		
		return "home.jsp";
	}
	
	@RequestMapping("/deleteAlien")
	public String deleteAlien(@RequestParam("aid") int aid) {
		repo.deleteById(aid);
		
		return "home.jsp";
	}
	
	/* Restful APIs */
	/*
	 * @RequestMapping("/aliens")
	 * 
	 * @ResponseBody public String getAllAliens() { return
	 * repo.findAll().toString(); }
	 * 
	 * @RequestMapping("/alien/{aid}")
	 * 
	 * @ResponseBody public String getAlienById(@PathVariable("aid") int aid) {
	 * return repo.findById(aid).toString(); }
	 */
	
	
	/* @RequestMapping(path="/aliens",produces="application/xml") */
	@RequestMapping("/aliens") 
	/* @ResponseBody */ //As we are using @RestController now
	public List<Alien> getAllAliens() { //returns data in JSON format
		return repo.findAll();
	}
	
	@RequestMapping("/alien/{aid}")
	/* @ResponseBody */ //As we are using @RestController now
	public Optional<Alien> getAlienById(@PathVariable("aid") int aid) { //returns data in JSON format
		return repo.findById(aid);
	}
	
	
	/* Post API */
	/* @PostMapping(path="/alien",consumes= {"application/json"}) */  //server will consume data in JSON fromat only
	@PostMapping("/alien") 
	public Alien addAlienPost(@RequestBody Alien alien) { //getting the data
		repo.save(alien);	//adding the data to the database
		return alien;	//returning the data that we got
	}
	
	/* Delete API */
	@DeleteMapping("/alien/{aid}")
	public String deleteAlienById(@PathVariable int aid) {
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "Deleted successfully";
	}
	
	/* Put API */
	@PutMapping(path="/alien",consumes= {"application/json"})
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
}
