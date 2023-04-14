package com.pasa.api.model.services;

import com.pasa.api.model.dtos.StudentDto;
import com.pasa.api.model.entities.Student;
import com.pasa.api.model.repositories.StudentRepository;
import com.pasa.api.model.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class StudentServiceImplementation implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public List<Student> findAll(){
        return this.studentRepository.findAll();
    }

    @Transactional
    public Optional<Student> findById(Long id){
        return this.studentRepository.findById(id);
    }

    @Transactional
    public Student save(Student student){
        return this.studentRepository.saveAndFlush(student);
    }

    @Transactional
    public void deleteById(Long id){
        this.studentRepository.deleteById(id);
    }

    @Transactional
    public Student update(Long id, Student student) {
        Optional<Student> main_student = null;

        main_student = this.studentRepository.findById(id);

        if(main_student.isPresent()){
            main_student.get().setFirstName(student.getFirstName());
            main_student.get().setLastName(student.getLastName());
            main_student.get().setAge(student.getAge());
            main_student.get().setGender(student.getGender());
            this.studentRepository.save(main_student.get());
        }

        return main_student.orElseThrow();
    }

    @Transactional(readOnly = true)
    public Optional<StudentDto> findByFirstName(String first_name){
        return this.studentRepository.findByFirstName(first_name);
    }

    @Transactional(readOnly = true)
    public List<StudentDto> findByFirstNameContaining(String first_name) {
        return this.studentRepository.findByFirstNameContaining(first_name);
    }
}
