package com.pasa.api.controllers;

import com.pasa.api.model.dtos.StudentDto;
import com.pasa.api.model.entities.Student;
import com.pasa.api.model.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok().body(studentService.findAll());
    }

    @GetMapping("/all")
    public List<Student> findAllOther() {
        return studentService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student){
        return ResponseEntity.created(null).body(this.studentService.update(id, student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable("id") Long id) {
        return ResponseEntity.of(this.studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student){
        return ResponseEntity.created(null).body(this.studentService.save(student));
    }

    @GetMapping("/findbyname")
    public ResponseEntity<StudentDto> findByFirstName(@RequestParam String name) {
        return ResponseEntity.of(this.studentService.findByFirstName(name));
    }

    @GetMapping("findbynamecontaining")
    public List<StudentDto> findByFirstNameContaining(@RequestParam String name){
        return this.studentService.findByFirstNameContaining(name);
    }

}
