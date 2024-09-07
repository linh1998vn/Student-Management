package com.example.studentmanagement.service.IMPL;


import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.dto.StudentSaveDTO;
import com.example.studentmanagement.dto.StudentUpdateDTO;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repo.StudentRepo;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {
    @Autowired
    private  StudentRepo studentRepo;
    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {
        Student student = new Student(
                studentSaveDTO.getStudentname(),
                studentSaveDTO.getAddress(),
                studentSaveDTO.getPhone()
        );
        studentRepo.save(student);
        return student.getStudentname();
    }
    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> getStudents = studentRepo.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(Student student:getStudents)
        {
            StudentDTO studentDTO = new StudentDTO(
                    student.getStudentid(),
                    student.getStudentname(),
                    student.getAddress(),
                    student.getPhone()
            );
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }
    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {
        if(studentRepo.existsById(studentUpdateDTO.getStudentid()))
        {
            Student student = studentRepo.getById(studentUpdateDTO.getStudentid());
            student.setStudentname(studentUpdateDTO.getStudentname());
            student.setAddress(studentUpdateDTO.getAddress());
            student.setPhone(studentUpdateDTO.getPhone());
            studentRepo.save(student);
            return student.getStudentname();
        }
        else
        {
            System.out.println("Student ID Not Found");
        }
        return null;
    }

    @Override
    public boolean deleteStudent(int id) {
        if(studentRepo.existsById(id))
        {
            studentRepo.deleteById(id);
        }
        else
        {
            System.out.println("Student ID Not Found");
        }
        return false;
    }
}
