package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDto;
import com.app.dto.StudentResposeDto;

public interface StudentService {

	List<StudentResposeDto> getAllStudents();
	ApiResponse addStudent(StudentDto StudDto);
	
}
