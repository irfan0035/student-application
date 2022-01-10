package com.example.students.Controller;

import com.example.students.Service.StudentService;
import com.example.students.dtos.AttendanceDto;
import com.example.students.dtos.StudentClassDto;
import com.example.students.dtos.StudentDto;
import liquibase.pro.packaged.A;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/add")
    public StudentDto add(@RequestBody StudentDto studentDto){

        return studentService.addStudent(studentDto);
    }
    @GetMapping("/all")
    public List<StudentDto> show(){
        return studentService.getStudents();
    }

    @GetMapping("/all/details")
    public List<StudentDto> allDetails(){
        return studentService.getStudentDetails();
    }


    @PostMapping("/add/attendance")
    public AttendanceDto addAttendence(@RequestBody AttendanceDto attendanceDto ){

        return studentService.addAttendance(attendanceDto);
    }
    @GetMapping("/show/attendance")
    public List<AttendanceDto> show2(){
        return studentService.getAttendance();
    }



    @PostMapping("/class-association/add")
    public StudentClassDto add1(@RequestBody StudentClassDto studentClassDto){
        return studentService.addStudentClass(studentClassDto);
    }

    @GetMapping("/show/student-class")
    public List<StudentClassDto> show1(){
        return studentService.getStudentClass();
    }



}
