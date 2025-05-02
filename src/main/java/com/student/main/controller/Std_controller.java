package com.student.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.main.entity.Students;
import com.student.main.services.StudentServices;

@Controller
public class Std_controller {
	@Autowired
	 private StudentServices studentservice;
	@GetMapping("/home")
	public String home() {
		return "home"; //view page  home.html
	}
	
	
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students",studentservice.getAllStudents());  //get this attribute in tthymeleaf
		return "students";
		
	}
	@GetMapping("/students/new")
	public String createstudentform(Model model) {
		Students student=new Students();  // to hold student object
		model.addAttribute("student",student);
		return "createstudentform";
	}
	@PostMapping("/students")
	public String saveStudent( @ModelAttribute("student")Students student , Model model) {
		studentservice.saveStudent(student);
		model.addAttribute("message","Student Registered Successfully!");
		return "redirect:/students";
		
	}
	
	 @GetMapping("/success")
	    public String showSuccessPage(Model model) {
	        model.addAttribute("message", "Student Registered Successfully!");
	        return "success"; // success.html in templates
	    }
	@GetMapping("/students/edit/{id}")
	public String editStudentform(@PathVariable int id, Model model) {
		model.addAttribute("student",studentservice.getById(id));
		return "edit_student";
		
	}
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute("student")  Students student) {
	Students existingStudent=studentservice.getById(id);
	existingStudent.setFirstname(student.getFirstname());
	existingStudent.setMiddlename(student.getMiddlename());
	existingStudent.setMiddlename(student.getLastname());
	existingStudent.setDob(student.getDob());
	existingStudent.setAge(student.getAge());
	existingStudent.setGender(student.getGender());
	existingStudent.setAddress(student.getAddress());
	existingStudent.setMobile_no(student.getMobile_no());
	studentservice.saveStudent(existingStudent);
	return "redirect:/students";




	
	}
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id) {
		studentservice.deleteById(id);
		return "redirect:/students";

}
}