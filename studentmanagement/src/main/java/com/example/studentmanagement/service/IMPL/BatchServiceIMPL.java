package com.example.studentmanagement.service.IMPL;

import com.example.studentmanagement.dto.BatchDTO;
import com.example.studentmanagement.dto.BatchSaveDTO;
import com.example.studentmanagement.dto.BatchUpdateDTO;
import com.example.studentmanagement.entity.Batch;
import com.example.studentmanagement.repo.BatchRepo;
import com.example.studentmanagement.repo.CourseRepo;
import com.example.studentmanagement.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchServiceIMPL implements BatchService {
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private BatchRepo batchRepo;
    @Override
    public String addBatch(BatchSaveDTO batchSaveDTO) {
        Batch batch = new Batch(
                batchSaveDTO.getBatchname(),
                batchSaveDTO.getStartdate(),
                courseRepo.getById(batchSaveDTO.getCourseid())
        );
        batchRepo.save(batch);
        return batch.getBatchname();
    }
    @Override
    public List<BatchDTO> getAllBatches() {
        List<Batch> getBatches = batchRepo.findAll();
        List<BatchDTO> batchDTOList = new ArrayList<>();
        for(Batch batch:getBatches)
        {
            BatchDTO batchDTO = new BatchDTO(
                    batch.getBatchid(),
                    batch.getBatchname(),
                    batch.getCourse(),
                    batch.getStartdate()
            );
            batchDTOList.add(batchDTO);
        }
        return batchDTOList;
    }
    @Override
    public String updateBatch(BatchUpdateDTO batchUpdateDTO) {
        if(batchRepo.existsById(batchUpdateDTO.getBatchid()))
        {
            Batch batch = batchRepo.getById(batchUpdateDTO.getBatchid());
            batch.setBatchname(batchUpdateDTO.getBatchname());
            batch.setCourse(courseRepo.getById(batchUpdateDTO.getCourseid()));
            batch.setStartdate(batchUpdateDTO.getStartdate());
            batchRepo.save(batch);
            return batch.getBatchname();
        }
        else
        {
            System.out.println("Course ID Not Found");
        }
        return null;
    }
    @Override
    public boolean deleteBatch(int id) {
        if(batchRepo.existsById(id))
        {
            batchRepo.deleteById(id);
        }
        else
        {
            System.out.println("Course ID Not Found");
        }
        return false;
    }
}
