package com.app.dto;

import com.app.entity.CourseTitle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResposeDto {
	private String firstName;
	private String lastName;
	private String email;
	private CourseTitle courseTitle;
	private double scoreObtained;
}
