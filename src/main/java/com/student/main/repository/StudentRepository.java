package com.student.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.main.entity.Students;
@Repository
public interface StudentRepository extends JpaRepository<Students,Integer> {

}
