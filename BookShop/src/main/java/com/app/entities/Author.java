package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Author extends baseEntity{

	@Column(unique = true)
	private String authorname;
	@Min(20)
	private Integer age;
	private String address;
	@Email
	private String email;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[@#$%])[a-zA-Z0-9@#$%]{5,9}$")
	private String password;
	@Past
	private LocalDate DOB;
	@OneToMany(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<book> bookList = new ArrayList<>();
}
