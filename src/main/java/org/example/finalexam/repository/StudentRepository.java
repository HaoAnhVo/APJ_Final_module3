package org.example.finalexam.repository;

import org.example.finalexam.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT maHocSinh, hoTen, lop FROM HocSinh";

        try (Connection con = BaseRepository.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("maHocSinh");
                String name = rs.getString("hoTen");
                String className = rs.getString("lop");

                students.add(new Student(id, name, className));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student getStudentById(int id) {
        Student student = null;
        String query = "SELECT maHocSinh, hoTen, lop FROM HocSinh WHERE maHocSinh = ?";

        try (Connection con = BaseRepository.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("hoTen");
                    String className = rs.getString("lop");
                    student = new Student(id, name, className);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
