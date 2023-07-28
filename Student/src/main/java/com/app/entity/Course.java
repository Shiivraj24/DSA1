package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course extends BaseEntity{

	@Enumerated(EnumType.STRING)
	private CourseTitle courseTitle;
	private double fee;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "course",orphanRemoval = true,fetch = FetchType.EAGER)
	private List<Student> list = new ArrayList<>();
	
	public Course(CourseTitle courseTitle, double fee) {
		super();
		this.courseTitle = courseTitle;
		this.fee = fee;
	}
	
	
}
