package com.example.students.Service.impl;

import com.example.students.Entity.*;
import com.example.students.Exception.ResourseNotFound;
import com.example.students.Service.SubjectService;
import com.example.students.dtos.SubjectClassDto;
import com.example.students.dtos.SubjectDto;
import com.example.students.dtos.TeacherClassDto;
import com.example.students.mappers.*;
import com.example.students.repositories.SubjectClassRepository;
import com.example.students.repositories.SubjectRepository;
import com.example.students.repositories.TeacherRepository;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    SubjectClassRepository subjectClassRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public SubjectDto addSubject(SubjectDto subjectDto) {
//        SubjectEntity entity = SubjectMapper.INSTANCE.subjectDtoToEntity(subjectDto);
//        entity = subjectRepository.save(entity);
//        return SubjectMapper.INSTANCE.subjectEntityToDto(entity);

        TeacherEntity teacherEntity = teacherRepository.findById(subjectDto.getTeacherId()).orElse(null);
       if (teacherEntity == null){
           throw new ResourseNotFound("teacherId is invalid");
       }
       SubjectEntity subjectEntity = SubjectMapper.INSTANCE.subjectDtoToEntity(subjectDto);
       subjectEntity.setTeacherEntity(teacherEntity);
       subjectRepository.save(subjectEntity);
       return SubjectMapper.INSTANCE.subjectEntityToDto(subjectEntity);
    }

    @Override
    public List<SubjectDto> showSubject() {
        return Optional.ofNullable(subjectRepository.findAll()).orElse(Collections.emptyList())
                .stream()
                .map(SubjectMapper.INSTANCE::subjectEntityToDto )
                .collect(Collectors.toList());
    }

    @Override
    public SubjectClassDto addSubjectClass(SubjectClassDto subjectClassDto) {
        SubjectClassEntity entity = SubjectClassMapper.INSTANCE.subjectClassDtoToEntity(subjectClassDto);
        entity = subjectClassRepository.save(entity);
        return SubjectClassMapper.INSTANCE.subjectClassEntityToDto(entity);
    }

    @Override
    public List<SubjectClassDto> showSubjectClass() {
        return Optional.ofNullable(subjectClassRepository.findAll()).orElse(Collections.emptyList())
                .stream()
                .map(SubjectClassMapper.INSTANCE::subjectClassEntityToDto)
                .collect(Collectors.toList());
    }




//        List<SubjectEntity> subjectEntityList = subjectRepository.findAll();
//        List<SubjectDto> subjectDtoList = new ArrayList<>();
//        for (SubjectEntity subjectEntity: subjectEntityList
//             ) {
//            SubjectDto subjectDto = SubjectMapper.INSTANCE.subjectEntityToDto(subjectEntity);
//            List<TeacherClassDto> teacherClassDtoList = new ArrayList<>();
//            for (TeacherClassEntity teacherClassEntity:subjectEntity.getTeacherClassEntity()
//                 ) {
//                TeacherClassDto teacherClassDto = TeacherClassMapper.INSTANCE.teacherClassEntityToDto(teacherClassEntity);
//                teacherClassDtoList.add(teacherClassDto);
//            }
//            subjectDto.setTeacherClassDto(teacherClassDtoList);
//            subjectDtoList.add(subjectDto);
//
//        }
//
//        return subjectDtoList;
//    }
    }


