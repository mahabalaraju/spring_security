package com.worker.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.worker.Repository.workerrepo;
import com.worker.entity.worker;
import com.worker.service.workerService;

@Controller
public class resosacontroller {

	@Autowired
	private workerService workerSer;
	
	@GetMapping({"/main","welcome","/"})
	public String welcomepage() {
		return "welcome";
	}
	
	@GetMapping({"/getworker","check","/list"})
	public ModelAndView mddsa(Model model) {
		List<worker> getal=workerSer.getall();
		return new ModelAndView("all_worker","worker",getal);
	}

	
	@GetMapping("/register")
	public String asd(Model model) {
		worker work = new worker();
		model.addAttribute("message", work);

		List<String> professionList = Arrays.asList("Devoloper", "designer", "architect");
		model.addAttribute("professionList", professionList);
		
		return "home";
	}
	
	
	@PostMapping("/save")
	public String savetheuser(@ModelAttribute worker work) {
		workerSer.upsert(work);
		return "redirect:/list";
	}
	
//@GetMapping("/showupdatedform")
//public ModelAndView showupdatedform(@RequestParam int id) {
//	workerSer.upsert(id);
//	return new ModelAndView("home","worker",worker);
//}



@GetMapping("/deleteWorker")
public String deleteworker(@RequestParam int id) {
	workerSer.delete(id);
	return "redirect:/list";
}
		
	
	
	
	
	
	
	
	
	
	
}
