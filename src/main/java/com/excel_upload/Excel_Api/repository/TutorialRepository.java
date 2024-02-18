package com.excel_upload.Excel_Api.repository;



import com.excel_upload.Excel_Api.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
