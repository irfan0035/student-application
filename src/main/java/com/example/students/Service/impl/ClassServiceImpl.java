package com.example.students.Service.impl;

import com.example.students.Entity.ClassEntity;
import com.example.students.Entity.SubjectEntity;
import com.example.students.Service.ClassService;
import com.example.students.dtos.ClassDto;
import com.example.students.dtos.SubjectDto;
import com.example.students.mappers.ClassMapper;
import com.example.students.mappers.SubjectMapper;
import com.example.students.repositories.ClassRepository;
import com.example.students.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassRepository classRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public ClassDto addClass(ClassDto classDto) {
        ClassEntity entity;
        entity = ClassMapper.INSTANCE.classDtoToEntity(classDto);
        entity = classRepository.save(entity);
        return ClassMapper.INSTANCE.classEntityToDto(entity);
    }
    @Override
    public List<ClassDto> showClass() {
        return Optional.ofNullable(classRepository.findAll()).orElse(Collections.emptyList())
                .stream()
                .map(ClassMapper.INSTANCE::classEntityToDto)
                .collect(Collectors.toList());
    }
    public List<ClassDto> showClassDetails(){
        List<ClassEntity> classEntityList = classRepository.findAll();
        List<ClassDto> classDtoList = new ArrayList<>();
        for (ClassEntity classEntity: classEntityList
             ) {
            ClassDto classDto = ClassMapper.INSTANCE.classEntityToDto(classEntity);
            List<SubjectEntity> subjectEntityList = subjectRepository.findAll();
            //SubjectDto subjectDto = new SubjectDto();
            List<SubjectDto> subjectDtoList = new ArrayList<>();
            for (SubjectEntity subjectEntity:classEntity.getSubjectEntityList()
                 ) {
                SubjectDto subjectDto = SubjectMapper.INSTANCE.subjectEntityToDto(subjectEntity);
                subjectDtoList.add(subjectDto);
            }
            classDto.setSubjectDtoList(subjectDtoList);
            classDtoList.add(classDto);
        }

        return classDtoList;
    }

}
