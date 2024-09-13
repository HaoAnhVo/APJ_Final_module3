package org.example.finalexam.service;

import org.example.finalexam.model.Student;

import java.util.List;

public interface IStudentService {
    public Student getStudentById(int id);
    public List<Student> getAllStudents();
}
