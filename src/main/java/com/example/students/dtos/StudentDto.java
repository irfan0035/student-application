package com.example.students.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDto {

    private Long id;

    private String name;

    private int age;

    private String address;

    private List<ClassDto> classDtoList;

    private List<AttendanceDto> attendanceDtoList;

}
