package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.dto.StudentSaveDTO;
import com.example.studentmanagement.dto.StudentUpdateDTO;

import java.util.List;

public interface StudentService {
    String addStudent(StudentSaveDTO studentSaveDTO);
    List<StudentDTO> getAllStudents();
    String updateStudent(StudentUpdateDTO studentUpdateDTO);
    boolean deleteStudent(int id);
}
