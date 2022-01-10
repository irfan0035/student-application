package com.example.students.Controller;

import com.example.students.Service.ClassService;
import com.example.students.Service.TeacherService;
import com.example.students.dtos.ClassDto;
import com.example.students.dtos.TeacherClassDto;
import com.example.students.dtos.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/add")
    public TeacherDto add(@RequestBody TeacherDto teacherDto) {
        return teacherService.addTeacher(teacherDto);
    }

    @GetMapping("/show")
    public List<TeacherDto> show(){
        return teacherService.getTeachers();
    }

    @GetMapping("/show/details")
    public List<TeacherDto> showDetails() {
        return teacherService.showTeachers();
    }



    @PostMapping("/add/teacher-class")
    public TeacherClassDto add1(@RequestBody TeacherClassDto teacherClassDto){
        return teacherService.addTeacherClass(teacherClassDto);
    }
//
//    @GetMapping("/show/teacher-class")
//    public List<TeacherDto> showAll1() {
//        return teacherService.showTeacherClass();
//    }
//


}
