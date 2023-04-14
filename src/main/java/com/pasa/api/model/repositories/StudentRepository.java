package com.pasa.api.model.repositories;

import com.pasa.api.model.entities.Student;

import com.pasa.api.model.dtos.StudentDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Optional<StudentDto> findByFirstName(String first_name);
    public List<StudentDto> findByFirstNameContaining(String first_name);
}
