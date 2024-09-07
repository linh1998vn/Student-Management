package com.example.studentmanagement.controller;


import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.dto.StudentSaveDTO;
import com.example.studentmanagement.dto.StudentUpdateDTO;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping(path = "/save")
    public String saveStudent(@RequestBody StudentSaveDTO studentSaveDTO)
    {
        String stname = studentService.addStudent(studentSaveDTO);
        return stname;
    }

    @GetMapping("/getAllStudents")
    public List<StudentDTO> getAllStudents()
    {
        List<StudentDTO> allStudents = studentService.getAllStudents();
        return allStudents;
    }
    @PutMapping(path = "/update")
    public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO)
    {
        String stname = studentService.updateStudent(studentUpdateDTO);
        return stname;
    }
    @DeleteMapping(path = "/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id")int id)
    {
        boolean deleteStudent = studentService.deleteStudent(id);
        return "deletedddddd!!!!";
    }
}
