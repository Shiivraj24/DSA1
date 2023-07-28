package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseDto;
import com.app.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseServ;

	@GetMapping()
	public ResponseEntity<?> getAllCourse() {
		return ResponseEntity.status(HttpStatus.OK).body(courseServ.getAllCourses());
	}

	@PostMapping("/add")
	public ResponseEntity<?> addCourse(@RequestBody CourseDto dto){
		return ResponseEntity.status(HttpStatus.OK).body(courseServ.addCourse(dto));
	}
	
}
