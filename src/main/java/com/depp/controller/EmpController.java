package com.depp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.depp.entity.Employee;
import com.depp.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@GetMapping("/")
	public String home(Model model)
	{
		List<Employee> emp =empService.getAllEmp();
		
		model.addAttribute("emp",emp);
		
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmployee()
	{
		return "addEmp";
	}
	

	  @PostMapping("/register") 
	  public String registerEmployee(@ModelAttribute Employee e, HttpSession session) { 
		  System.out.println(e); 
		  empService.addEmp(e);
		  
		  session.setAttribute("msg","employee added successfully..!!!");
		  
	  return "redirect:/";
	  }
	  
	  @GetMapping("/edit/{id}")
	  public String edit(@PathVariable int id, Model model)
	  {
		 Employee e= empService.getEmpById(id);
		 model.addAttribute("emp", e);
		  
		  return "edit";
	  }
	  
	  @PostMapping("/update")
	  public String updateEmp(@ModelAttribute Employee e, HttpSession session)
	  {	
		  empService.addEmp(e);
		 session.setAttribute("msg","employee Data update successfully...!!");
		  
		  return "redirect:/";
		  
	  }
	  
	  @GetMapping("/delete/{id}")
	  public String deleteEmp(@PathVariable int id, HttpSession session)
	  {
		 empService.deleteEmp(id);
		 session.setAttribute("msg","Delete Employee Successfully....!!");
		  return"redirect:/";
	  }
	
}
