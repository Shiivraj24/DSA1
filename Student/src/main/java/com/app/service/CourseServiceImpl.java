package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDto;
import com.app.dto.CourseResponseDto;
import com.app.entity.Course;
import com.app.repository.CourseRepository;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<CourseResponseDto> getAllCourses() {
		List<Course> c = courseRepo.findAll();
		List<CourseResponseDto> c1 = new ArrayList<>();
		c.forEach((v)->{c1.add(mapper.map(v, CourseResponseDto.class));});
		return c1;
	}

	@Override
	public ApiResponse addCourse(CourseDto cDto) {
		Course c = new Course(cDto.getCourseTitle(),cDto.getFee());
		courseRepo.save(c);
		return new ApiResponse("Course added successfully");
	}

}
