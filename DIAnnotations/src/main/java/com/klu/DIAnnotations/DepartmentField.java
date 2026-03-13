package com.klu.DIAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentField {
	@Autowired
	private Student student;
	public void show() {
		student.display();
		System.out.println("Calling through Feild injection!...");
	}

}
