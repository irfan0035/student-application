package com.example.students.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
@Getter
@Setter
public class StudentClassDto {

    private Long id;

    private Long StudentId;

   private Long classId;
}
