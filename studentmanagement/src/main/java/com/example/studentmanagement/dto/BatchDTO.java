package com.example.studentmanagement.dto;

import com.example.studentmanagement.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BatchDTO {
    private int batchid;
    private String batchname;
    private Course course;
    private String startdate;

}
