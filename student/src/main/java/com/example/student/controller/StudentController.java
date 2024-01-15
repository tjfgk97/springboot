package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.student.dto.StudentDTO;
import com.example.student.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	//학생 등록 화면 출력
	@GetMapping("/save")
	public String save() {
		return "save";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute StudentDTO studentDTO) {
		System.out.println("StudentDTO = " + studentDTO);
		return "index";
	}
}
