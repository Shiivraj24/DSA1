package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDto;
import com.app.dto.CourseResponseDto;

public interface CourseService {
	
	List<CourseResponseDto> getAllCourses();
	ApiResponse addCourse(CourseDto cDto);

	
}
