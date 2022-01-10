package com.example.students.dtos;

import com.example.students.Entity.ClassEntity;
import com.example.students.Entity.TeacherEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Set;

@Getter
@Setter
public class TeacherClassDto {

    private Long id;

    private Long classId;

    private Long teacherId;

  //  private SubjectDto subjectDto;


}
