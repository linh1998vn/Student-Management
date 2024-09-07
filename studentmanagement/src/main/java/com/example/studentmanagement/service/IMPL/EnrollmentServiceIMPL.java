package com.example.studentmanagement.service.IMPL;

import com.example.studentmanagement.dto.EnrollmentDTO;
import com.example.studentmanagement.dto.EnrollmentSaveDTO;
import com.example.studentmanagement.dto.EnrollmentUpdateDTO;
import com.example.studentmanagement.entity.Enrollment;
import com.example.studentmanagement.repo.BatchRepo;
import com.example.studentmanagement.repo.EnrollmentRepo;
import com.example.studentmanagement.repo.StudentRepo;
import com.example.studentmanagement.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentServiceIMPL implements EnrollmentService {
    @Autowired
    private EnrollmentRepo enrollmentRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private BatchRepo batchRepo;
    @Override
    public String addEnrollment(EnrollmentSaveDTO entrollmentSaveDTO) {
        Enrollment enrollment = new Enrollment(
                studentRepo.getById(entrollmentSaveDTO.getStudent_id()),
                batchRepo.getById(entrollmentSaveDTO.getBatch_id()),
                entrollmentSaveDTO.getJoindate(),
                entrollmentSaveDTO.getFee()
        );
        enrollmentRepo.save(enrollment);
        return enrollment.getJoindate();
    }
    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        List<Enrollment> getEnrollments = enrollmentRepo.findAll();
        List<EnrollmentDTO> enrollmentDTOList = new ArrayList<>();
        for(Enrollment enrollment:getEnrollments)
        {
            EnrollmentDTO enrollmentDTO = new EnrollmentDTO(
                    enrollment.getEnrollid(),
                    enrollment.getStudent(),
                    enrollment.getBatch(),
                    enrollment.getJoindate(),
                    enrollment.getFee()
            );
            enrollmentDTOList.add(enrollmentDTO);
        }
        return enrollmentDTOList;
    }
    @Override
    public String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO) {
        if(enrollmentRepo.existsById(enrollmentUpdateDTO.getEnrollid()))
        {
            Enrollment enrollment  = enrollmentRepo.getById(enrollmentUpdateDTO.getEnrollid());
            enrollment.setStudent(studentRepo.getById(enrollmentUpdateDTO.getStudent_id()));
            enrollment.setBatch(batchRepo.getReferenceById(enrollmentUpdateDTO.getBatch_id()));
            enrollment.setJoindate(enrollmentUpdateDTO.getJoindate());
            enrollment.setFee(enrollmentUpdateDTO.getFee());
            enrollmentRepo.save(enrollment);
            return enrollment.getJoindate();
        }
        else
        {
            System.out.println("Enrollment ID Not Found");
        }
        return null;
    }
    @Override
    public boolean deleteEnrollment(int id) {
        if(enrollmentRepo.existsById(id))
        {
            enrollmentRepo.deleteById(id);
        }
        else
        {
            System.out.println("Enrollment ID Not Found");
        }
        return false;
    }
}
