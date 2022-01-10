package com.example.students.Service;

import com.example.students.dtos.MarksDto;
import com.example.students.dtos.SubjectClassDto;
import com.example.students.dtos.SubjectDto;

import java.util.List;

public interface SubjectService {
    SubjectDto addSubject(SubjectDto subjectDto);

    List<SubjectDto> showSubject();

    SubjectClassDto addSubjectClass(SubjectClassDto subjectClassDto);

    List<SubjectClassDto> showSubjectClass();

    //List<SubjectDto> showSubjectTeacher();

}
