package com.example.students.Service;

import com.example.students.Exception.ResourceExist;
import com.example.students.dtos.AttendanceDto;
import com.example.students.dtos.StudentClassDto;
import com.example.students.dtos.StudentDto;
import com.example.students.dtos.TeacherDto;

import java.util.List;

public interface StudentService {
    StudentDto addStudent(StudentDto studentDto) throws ResourceExist;

//    StudentDto getStudentByName(String name); //throws ResourceNotFound;
//
    List<StudentDto> getStudents();

    AttendanceDto addAttendance(AttendanceDto attendanceDto);

    List<AttendanceDto> getAttendance();

    StudentClassDto addStudentClass(StudentClassDto studentClassDto) throws ResourceExist;

    List<StudentClassDto> getStudentClass();

    List<StudentDto> getStudentDetails();
}
