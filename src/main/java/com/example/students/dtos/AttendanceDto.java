package com.example.students.dtos;

import com.example.students.Entity.StudentEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ForeignKey;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AttendanceDto {

    private Long id;

    private Long StudentId;

    private Date date;

    private String attendance;

   // private StudentDto studentDto;
}
