package org.example.finalexam.service;

import org.example.finalexam.model.Student;
import org.example.finalexam.repository.IStudentRepository;
import org.example.finalexam.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    IStudentRepository iStudentRepository = new StudentRepository();

    @Override
    public Student getStudentById(int id) {
        return iStudentRepository.getStudentById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return iStudentRepository.getAllStudents();
    }
}
