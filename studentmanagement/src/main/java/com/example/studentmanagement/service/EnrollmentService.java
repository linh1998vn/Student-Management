package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.EnrollmentDTO;
import com.example.studentmanagement.dto.EnrollmentSaveDTO;
import com.example.studentmanagement.dto.EnrollmentUpdateDTO;

import java.util.List;

public interface EnrollmentService {
    String addEnrollment(EnrollmentSaveDTO entrollmentSaveDTO);
    List<EnrollmentDTO> getAllEnrollments();
    String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO);
    boolean deleteEnrollment(int id);
}
