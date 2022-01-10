package com.example.students.Service.impl;

import com.example.students.Entity.ClassEntity;
import com.example.students.Entity.MarksEntity;
import com.example.students.Entity.StudentEntity;
import com.example.students.Entity.SubjectEntity;
import com.example.students.Exception.ResourseNotFound;
import com.example.students.Service.MarkService;
import com.example.students.dtos.ClassDto;
import com.example.students.dtos.MarksDto;
import com.example.students.dtos.StudentDto;
import com.example.students.dtos.SubjectDto;
import com.example.students.mappers.ClassMapper;
import com.example.students.mappers.MarkMapper;
import com.example.students.mappers.StudentMapper;
import com.example.students.mappers.SubjectMapper;
import com.example.students.repositories.ClassRepository;
import com.example.students.repositories.MarkRepository;
import com.example.students.repositories.StudentRepository;
import com.example.students.repositories.SubjectRepository;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    MarkRepository markRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassRepository classRepository;
    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public MarksDto addMarks(MarksDto marksDto) {
//        MarksEntity entity;
//        entity = MarkMapper.INSTANCE.markDtoToEntity(marksDto);
//        entity = markRepository.save(entity);
//        return MarkMapper.INSTANCE.markEntityToDto(entity);

        StudentEntity studentEntity = studentRepository.findById(marksDto.getStudentId()).orElse(null);
        if (studentEntity == null) {
            throw new ResourseNotFound("Student ID is Invalid !!!! Plesase enter Corect Student Id");
        }
        SubjectEntity subjectEntity = subjectRepository.findById(marksDto.getSubjectId()).orElse(null);
        if (subjectEntity == null) {
            throw new ResourseNotFound("Subject ID is Invalid !!!! Plesase enter Corect Subject Id");
        }

        ClassEntity classEntity = classRepository.findById(marksDto.getClassId()).orElse(null);
        if (classEntity == null)
            throw new ResourseNotFound("Class Id is invalid !!! plesase enter correct classId");

        MarksEntity marksEntity = MarkMapper.INSTANCE.markDtoToEntity(marksDto);
        marksEntity.setStudentEntity(studentEntity);
        marksEntity.setClassEntity(classEntity);
        marksEntity.setSubjectEntity(subjectEntity);

        marksEntity = markRepository.save(marksEntity);

        return MarkMapper.INSTANCE.markEntityToDto(marksEntity);

    }

    public List<MarksDto> showMark(){
        List<MarksEntity> marksEntityList = markRepository.findAll();
        List<MarksDto> marksDtoList = new ArrayList<>();
        for (MarksEntity marksEntity: marksEntityList
             ) {
            MarksDto marksDto = MarkMapper.INSTANCE.markEntityToDto(marksEntity);
            marksDtoList.add(marksDto);
        }
        return marksDtoList;
    }

    @Override
    public List<MarksDto> showMarks() {
//        return Optional.ofNullable(markRepository.findAll()).orElse(Collections.emptyList())
//                .stream()
//                .map(MarkMapper.INSTANCE::markEntityToDto)
//                .collect(Collectors.toList());
//
        List<MarksEntity> marksEntityList = markRepository.findAll();
        List<MarksDto> marksDtoList = new ArrayList<>();
//        StudentDto studentDto = new StudentDto();
      //  List<StudentEntity> studentEntityList = studentRepository.findAll();
        //StudentEntity studentEntity = studentRepository.findById(studentDto.getId()).orElse(null);
        for (MarksEntity marksEntity : marksEntityList
        ) {
            StudentDto studentDto = new StudentDto();
            MarksDto marksDto = MarkMapper.INSTANCE.markEntityToDto(marksEntity);
            StudentEntity studentEntity = studentRepository.findById(marksEntity.getStudentId()).orElse(null);
            StudentDto studentDto1 = StudentMapper.INSTANCE.toDto(studentEntity);
//            studentDto.setName(studentDto1.getName());





            SubjectDto subjectDto = new SubjectDto();
            SubjectEntity subjectEntity = subjectRepository.findById(marksEntity.getSubjectId()).orElse(null);
            SubjectDto subjectDto1 = SubjectMapper.INSTANCE.subjectEntityToDto(subjectEntity);
            //subjectDto.setName(subjectDto1.getName());

            ClassDto classDto = new ClassDto();
            ClassEntity classEntity = classRepository.findById(marksEntity.getClassId()).orElse(null);
            ClassDto classDto1 = ClassMapper.INSTANCE.classEntityToDto(classEntity);
//            classDto.setName(classDto1.getName());


//            marksDto.setStudentDto(studentDto);
//            marksDto.setSubjectDto(subjectDto);
//            marksDto.setClassDto(classDto);


            marksDto.setStudentDto(studentDto1);
            marksDto.setSubjectDto(subjectDto1);
            marksDto.setClassDto(classDto1);


            marksDtoList.add(marksDto);
        }
            //StudentEntity studentEntity = StudentMapper.INSTANCE.toEntity(studentDto);

            return marksDtoList;

        }
    }
