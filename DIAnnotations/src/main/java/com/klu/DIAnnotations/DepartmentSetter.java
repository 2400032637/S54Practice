package com.klu.DIAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class DepartmentSetter {
	private Student student;
	@Autowired

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	public void show() {
		student.display();
		System.out.println("Setter injection!.....");
	}

}
