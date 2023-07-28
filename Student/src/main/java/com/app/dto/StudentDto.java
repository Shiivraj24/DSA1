package com.app.dto;

import javax.validation.constraints.NotBlank;

import com.app.entity.CourseTitle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

	@NotBlank(message = "name cannot be null")
	private String firstName;
	private String lastName;
	private String email;
	private CourseTitle courseTitle;
	private double scoreObtained;
	private long course_id;
}
