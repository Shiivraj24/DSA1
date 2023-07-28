package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDto;
import com.app.dto.StudentResposeDto;
import com.app.entity.Student;
import com.app.exception.CustomException;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CourseRepository courseRepo;
	
	@Override
	public List<StudentResposeDto> getAllStudents() {
		List<Student> studList = studentRepo.findAll();
		List<StudentResposeDto> stud = new ArrayList<>();
		studList.forEach((v)->{stud.add(mapper.map(v,StudentResposeDto.class));});
		return stud;
	}

	@Override
	public ApiResponse addStudent(StudentDto StudDto) {
		Student s = new Student(StudDto.getFirstName(),StudDto.getLastName(),StudDto.getEmail(),StudDto.getCourseTitle(), StudDto.getScoreObtained());
		courseRepo.findById(StudDto.getCourse_id()).map((course)->{
		s.setCourse(course);
		return studentRepo.save(s);
		}).orElseThrow(()->new CustomException("not found"));
		return new ApiResponse("Student Added");
	}

}
