package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentDto;
import com.app.service.StudentService;

@RestController
@RequestMapping("/student")
@Validated
public class StudentController {

	@Autowired
	private StudentService studServ;
	
	@GetMapping
	public ResponseEntity<?> getAllStudent(){
		return ResponseEntity.status(HttpStatus.OK).body(studServ.getAllStudents());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody @Valid StudentDto stud){
		return ResponseEntity.status(HttpStatus.OK).body(studServ.addStudent(stud));
	}
	
}
