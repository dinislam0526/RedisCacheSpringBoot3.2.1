package com.radis.radisCacheProject.controller;

import com.radis.radisCacheProject.entity.Student;
import com.radis.radisCacheProject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

   @Autowired
   private StudentService studentService;
   @Cacheable(value = "student",key = "#id")
   @GetMapping("/student/{id}")
   public Student findStudentById(@PathVariable Long id){
       return studentService.findById(id);
   }

   @CachePut(value = "student",key = "#student.id")
   @PutMapping("/student")
   public Student updateStudent(@RequestBody Student student){
       return studentService.uddateStudent(student);
   }

   @CacheEvict(value = "student",key = "#id")
   @DeleteMapping("/student/{id}")
   public void deleteStudent(@PathVariable Long id){
      studentService.deleteStudent(id);
   }

}
