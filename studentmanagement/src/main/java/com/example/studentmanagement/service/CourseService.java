package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.CourseDTO;
import com.example.studentmanagement.dto.CourseSaveDTO;
import com.example.studentmanagement.dto.CourseUpdateDTO;

import java.util.List;

public interface CourseService {
    String addCourse(CourseSaveDTO courseSaveDTO);
    List<CourseDTO> getAllCourses();
    String updateCourse(CourseUpdateDTO courseUpdateDTO);
    boolean deleteCourse(int id);
}
