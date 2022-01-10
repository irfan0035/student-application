package com.example.students.dtos;

import com.example.students.Entity.SubjectEntity;
import com.example.students.Entity.TeacherEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
;

@Getter
@Setter
public class ClassDto {

    private Long id;

    private String name;

    private List<SubjectDto> subjectDtoList;

    //private List<TeacherDto> teacherDtoList;
}
