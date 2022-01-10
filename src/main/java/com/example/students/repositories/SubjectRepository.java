package com.example.students.repositories;

import com.example.students.Entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity,Long> {
}
