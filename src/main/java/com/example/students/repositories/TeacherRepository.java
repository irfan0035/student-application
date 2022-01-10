package com.example.students.repositories;

import com.example.students.Entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity,Long> {
    TeacherEntity getTeacherByName(String name);
}
