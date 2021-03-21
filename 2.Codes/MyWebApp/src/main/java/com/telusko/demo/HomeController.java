package com.telusko.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("home")
	public ModelAndView home(Alien alien) {
				
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alien);
		
		mv.setViewName("home");
		
		return mv;
	}
	
/*	public ModelAndView home(@RequestParam("name") String myName,@RequestParam("profile") String myProfile) {
		 Passing data: http://localhost:8080/home?name=Prakash&profile=FullStack 		
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", myName);
		mv.addObject("profile", myProfile);
		
		mv.setViewName("home");
		
		return mv;
	}*/
	
/*	public String home(HttpServletRequest req,HttpServletResponse res) {
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		session.setAttribute("name", name);
		System.out.println("Hi "+ name); 
		return "home";
	}*/
}
