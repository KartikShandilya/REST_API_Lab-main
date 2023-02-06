package com.greatlearning.studentmanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.studentmanagement.model.Student;
import com.greatlearning.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/list")
	public String getAllStudents(Model model) {
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("Students", students);
		return "list-Students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "Student-Form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("Student", student);
		return "Student-Form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("Student") Student student) {
		studentService.save(student);
		return "redirect:/students/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int id) {
		studentService.delete(id);
		return "redirect:/students/list";
	}

	@RequestMapping("/403")
	public ModelAndView delete(Principal user) {
		ModelAndView model = new ModelAndView();
		if(user != null) {
			model.addObject("msg", "Hi "+user.getName()+" you don't have permission to perform this action");
		}else {
			model.addObject("msg", "Hi,  you don't have permission to perform this action");
		}
		model.setViewName("403");
		return model;
	}
	

}
