package com.example.students.Service;

import com.example.students.dtos.MarksDto;
import com.example.students.dtos.SubjectDto;

import java.util.List;

public interface MarkService {
    MarksDto addMarks(MarksDto marksDto);

    List<MarksDto> showMarks();

    List<MarksDto> showMark();
}
