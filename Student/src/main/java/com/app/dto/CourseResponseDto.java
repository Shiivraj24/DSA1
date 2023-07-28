package com.app.dto;

import com.app.entity.CourseTitle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDto {
	private CourseTitle courseTitle;
	private double fee;
}
