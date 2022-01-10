package com.example.students.dtos;

import com.example.students.Entity.ClassEntity;
import com.example.students.Entity.TeacherClassEntity;
import com.example.students.Entity.TeacherEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class TeacherDto {

    private long id;

    private String name;

    private int age;

    private int salary;

    private List<ClassDto> classDtoList;

    private List<SubjectDto> subjectDtoList;
}
