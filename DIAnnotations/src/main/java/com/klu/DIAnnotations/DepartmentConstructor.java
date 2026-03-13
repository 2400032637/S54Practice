package com.klu.DIAnnotations;

import org.springframework.stereotype.Component;

@Component
public class DepartmentConstructor {
	
	private Student student;
	public DepartmentConstructor(Student student) {
		this.student = student;
	}
	public void show() {
		student.display();
	}

}
