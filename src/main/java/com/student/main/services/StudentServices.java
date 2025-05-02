package com.student.main.services;

import java.util.List;


import com.student.main.entity.Students;

public interface StudentServices {
	public List<Students> getAllStudents();
	public Students saveStudent(Students student);
	public Students getById(int id);
	public void deleteById(int id);

}
