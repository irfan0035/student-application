package com.example.students.Controller;

import com.example.students.Service.ClassService;
import com.example.students.Service.SubjectService;
import com.example.students.dtos.ClassDto;
import com.example.students.dtos.SubjectClassDto;
import com.example.students.dtos.SubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @Autowired
    SubjectService subjectService;

    @PostMapping("/add")
    public ClassDto add(@RequestBody ClassDto classDto){
        return classService.addClass(classDto);
    }

    @GetMapping("/show")
    public List<ClassDto> showAll(){
        return classService.showClass();
    }

    @PostMapping("/add/subject")
    public SubjectDto addSubject(@RequestBody SubjectDto subjectDto){
        return subjectService.addSubject(subjectDto);
    }

    @GetMapping("/show/subject")
    public List<SubjectDto> showSubject()
    {
        return subjectService.showSubject();
    }

    @GetMapping("/show/class/details")
    public List<ClassDto> showClassDetails()
    {
        return classService.showClassDetails();
    }

    @PostMapping("/add/subject-class")
    public SubjectClassDto addSubjectClass(@RequestBody SubjectClassDto subjectClassDto){
        return subjectService.addSubjectClass(subjectClassDto);
    }

    @GetMapping("/show/subject-class")
    public List<SubjectClassDto> showSubjectClass()
    {
        return subjectService.showSubjectClass();
    }



    @GetMapping("/regex/{gmail}")
    public String regex(@PathVariable String gmail){

        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(gmail);
        boolean b = m.find();
        if(b){
            return "gmail is valid :"+gmail;
        }else return "gmail is invalid :"+gmail;

    }



}
