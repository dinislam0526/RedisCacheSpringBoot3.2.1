package com.radis.radisCacheProject.services;

import com.radis.radisCacheProject.entity.Student;
import com.radis.radisCacheProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student findById(Long id){
        return studentRepository.findById(id).get();
    }

    public Student uddateStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id){
       Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
        studentRepository.delete(student);
    }

}
