package com.example.students.repositories;

import com.example.students.Entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {
}
