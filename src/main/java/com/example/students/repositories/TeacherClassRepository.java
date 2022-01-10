package com.example.students.repositories;

import com.example.students.Entity.TeacherClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherClassRepository extends JpaRepository<TeacherClassEntity,Long> {
}
