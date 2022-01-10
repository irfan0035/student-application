package com.example.students.dtos;

import com.example.students.Entity.ClassEntity;
import com.example.students.Entity.TeacherEntity;
import jdk.internal.net.http.LineSubscriberAdapter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubjectDto {

    private long id;

    private String name;

    private Long teacherId;

    private List<ClassDto> classDtoList;


}
