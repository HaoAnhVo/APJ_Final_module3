package org.example.finalexam.repository;

import org.example.finalexam.model.Student;

import java.util.List;

public interface IStudentRepository {
    public Student getStudentById(int id);
    public List<Student> getAllStudents();
}
