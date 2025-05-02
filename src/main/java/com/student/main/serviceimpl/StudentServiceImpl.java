package com.student.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.main.entity.Students;
import com.student.main.repository.StudentRepository;
import com.student.main.services.StudentServices;

@Service
public class StudentServiceImpl implements StudentServices {
	@Autowired
	public StudentRepository studentrepository;

	@Override
	public List<Students> getAllStudents() {
		// TODO Auto-generated method stub }

		List<Students> list = studentrepository.findAll();
		return list;
	}

	@Override
	public Students saveStudent(Students student) {
		// TODO Auto-generated method stub
		return studentrepository.save(student);
	}

	@Override
	public Students getById(int id) {
		// TODO Auto-generated method stub
		return studentrepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		 studentrepository.deleteById(id);
		
	}

}
