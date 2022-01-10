package com.example.students.repositories;

import com.example.students.Entity.StudentClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentClassRepository  extends JpaRepository<StudentClassEntity, Long> {
    StudentClassEntity getStudnetById(Long studentId);
}
