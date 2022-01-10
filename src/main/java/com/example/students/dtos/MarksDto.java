package com.example.students.dtos;

import com.example.students.Entity.StudentEntity;
import com.example.students.Entity.SubjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
@Getter
@Setter
public class MarksDto {

    private Long id;

    private int mark;

    private Long studentId;

    private Long subjectId;

    private Long classId;

    private StudentDto studentDto;

    private SubjectDto subjectDto;

    private ClassDto classDto;




}
