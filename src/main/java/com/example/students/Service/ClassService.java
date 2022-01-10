package com.example.students.Service;

import com.example.students.Exception.ResourceExist;
import com.example.students.dtos.ClassDto;

import java.util.List;

public interface ClassService {
    ClassDto addClass(ClassDto classDto);
    List<ClassDto> showClass();
    List<ClassDto> showClassDetails();



}
