package com.skynet.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skynet.sms.entity.Student;
import com.skynet.sms.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String home() {
		System.out.println("Processing /...");
		return "index";
	} 
	
	
	// handler method to handle list student and return model and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		System.out.println("Processing /students...");
		model.addAttribute("students", studentService.getAllStudents());	// students.getAllStudents() is added in model under the name of "students"
		return "students";			// returning the view name
	}
	
	@GetMapping("/students/new")
	public String showCreateStudentForm(Model model) {
		System.out.println("Processing /students/new...");;
		
		// create empty student object to hold student form data
		Student student = new Student();
		model.addAttribute("student",student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String handleCreateStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String showUpdateStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "update_student";
	}
	
	@PostMapping("/students/{id}")
	public String handleUpdateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		System.out.println("student.id: " + student.getId());
		System.out.println("id: " + id);
		
		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		Student student = studentService.getStudentById(id);
		System.out.println("Deleting Student: " + student);
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
}

















