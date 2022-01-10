package com.example.students.Service;

import com.example.students.Exception.ResourceExist;
import com.example.students.dtos.TeacherClassDto;
import com.example.students.dtos.TeacherDto;

import java.util.List;

public interface TeacherService {

    TeacherDto addTeacher(TeacherDto teacherDto) throws ResourceExist;
    List<TeacherDto> getTeachers();
    List<TeacherDto> showTeachers();


//
    TeacherClassDto addTeacherClass(TeacherClassDto teacherClassDto);

    //List<TeacherDto> showTeacherClass();


}
