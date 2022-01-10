package com.example.students.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
@Getter
@Setter
public class SubjectClassDto {

    private Long id;

    private Long subjectId;

    private Long classId;
//    private Long teacherId;
}
