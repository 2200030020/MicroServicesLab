package klu.controller;
//For FrontEnd
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //-> To handle the ModelAndView Rest is used to handle the procedure
public class AppController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("college");
		return mv;
	
	}
	}
