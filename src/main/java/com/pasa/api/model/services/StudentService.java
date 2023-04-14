package com.pasa.api.model.services;

import com.pasa.api.model.entities.Student;

import com.pasa.api.model.dtos.StudentDto;

import java.util.*;
public interface StudentService {
    public List<Student> findAll();

    public Optional<Student> findById(Long id);

    public Student save(Student student);

    public void deleteById(Long id);

    public Student update(Long id, Student student);

    public Optional<StudentDto> findByFirstName(String first_name);

    public List<StudentDto> findByFirstNameContaining(String first_name);
}
