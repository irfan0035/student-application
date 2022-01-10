package com.example.students.repositories;

import com.example.students.Entity.MarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<MarksEntity,Long> {
}
