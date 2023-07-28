package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends BaseEntity{
	@Column(name="first_name" , length = 20)
	private String firstName;
	@Column(name="last_name" , length = 20)
	private String lastName;
	@Column(length = 20,unique = true)
	private String email;
	@Enumerated(EnumType.STRING)
	private CourseTitle courseTitle;
	@Column(name="score")
	private double scoreObtained;
	@ManyToOne()
	@JoinColumn(name="course_id")
	private Course course;
	
	public Student(String firstName, String lastName, String email, CourseTitle courseTitle, double scoreObtained) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.courseTitle = courseTitle;
		this.scoreObtained = scoreObtained;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", courseTitle="
				+ courseTitle + ", scoreObtained=" + scoreObtained + "]";
	}
	
	
	
	
}
