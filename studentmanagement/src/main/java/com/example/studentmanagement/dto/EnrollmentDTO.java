package com.example.studentmanagement.dto;

import com.example.studentmanagement.entity.Batch;
import com.example.studentmanagement.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollmentDTO {
    private int enrollid;
    private Student student;
    private Batch batch;
    private String joindate;
    private int fee;
}
