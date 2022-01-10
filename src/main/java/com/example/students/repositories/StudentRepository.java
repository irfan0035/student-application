package com.example.students.repositories;

import com.example.students.Entity.StudentClassEntity;
import com.example.students.Entity.StudentEntity;
import com.example.students.repositories.impl.StudentRepositoriesCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long>, StudentRepositoriesCustom {

//    @Query(value = "select * from student where id =:inpId",nativeQuery = true)
//    StudentEntity getStudentById(@Param("inpId") Long id);

    StudentEntity getStudentByName(String name);



}
