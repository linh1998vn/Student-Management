package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.BatchDTO;
import com.example.studentmanagement.dto.BatchSaveDTO;
import com.example.studentmanagement.dto.BatchUpdateDTO;

import java.util.List;

public interface BatchService {
    String addBatch(BatchSaveDTO batchSaveDTO);
    List<BatchDTO> getAllBatches();
    String updateBatch(BatchUpdateDTO batchUpdateDTO);
    boolean deleteBatch(int id);
}
