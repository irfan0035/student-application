package com.example.students.repositories;

import com.example.students.Entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity,Long> {

}
