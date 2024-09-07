package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.TeacherDTO;
import com.example.studentmanagement.dto.TeacherSaveDTO;
import com.example.studentmanagement.dto.TeacherUpdateDTO;

import java.util.List;

public interface TeacherService {
    String addTeacher(TeacherSaveDTO teacherSaveDTO);
    List<TeacherDTO> getAllTeachers();
    String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);
    boolean deleteTeacher(int id);
}