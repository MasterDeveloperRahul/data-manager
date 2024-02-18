package com.excel_upload.Excel_Api.service;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.excel_upload.Excel_Api.helper.ExcelHelper;
import com.excel_upload.Excel_Api.helper.ExcelHelper_Download;
import com.excel_upload.Excel_Api.model.Tutorial;
import com.excel_upload.Excel_Api.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.excel_upload.Excel_Api.model.Tutorial;


@Service
public class ExcelService {
    @Autowired
    TutorialRepository repository;

    public void save(MultipartFile file) {
        try {
            System.out.println("yaha sahi hai");
            List<Tutorial> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
            System.out.println("yaha bhi sahi hai");
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Tutorial> getAllTutorials() {
        return repository.findAll();
    }

    public ByteArrayInputStream load() {
        List<Tutorial> tutorials = repository.findAll();

        ByteArrayInputStream in = ExcelHelper_Download.tutorialsToExcel(tutorials);
        return in;
    }
}