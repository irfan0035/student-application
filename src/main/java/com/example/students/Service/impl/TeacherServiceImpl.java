package com.example.students.Service.impl;

import com.example.students.Entity.ClassEntity;
import com.example.students.Entity.SubjectEntity;
import com.example.students.Entity.TeacherClassEntity;
import com.example.students.Entity.TeacherEntity;
import com.example.students.Exception.ResourceExist;
import com.example.students.Service.TeacherService;
import com.example.students.dtos.ClassDto;
import com.example.students.dtos.SubjectDto;
import com.example.students.dtos.TeacherClassDto;
import com.example.students.dtos.TeacherDto;
import com.example.students.mappers.ClassMapper;
import com.example.students.mappers.SubjectMapper;
import com.example.students.mappers.TeacherClassMapper;
import com.example.students.mappers.TeacherMapper;
import com.example.students.repositories.ClassRepository;
import com.example.students.repositories.TeacherClassRepository;
import com.example.students.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherClassRepository teacherClassRepository;
    @Autowired
    ClassRepository classRepository;

    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto) throws ResourceExist {
        TeacherEntity entity1;
        entity1 = teacherRepository.getTeacherByName(teacherDto.getName());
        if (entity1 != null)
            throw new ResourceExist("Teacher name already exist");

        entity1 = TeacherMapper.INSTANCE.teacherDtoToEntity(teacherDto);
//        entity1 = teacherRepositories.findAll(entity1);
        entity1 = teacherRepository.save(entity1);
        return TeacherMapper.INSTANCE.teacherEntityToDto(entity1);
    }

    @Override
    public List<TeacherDto> showTeachers() {
        List<TeacherEntity> teacherEntityList = teacherRepository.findAll();
        List<TeacherDto> teacherDtoList = new ArrayList<>();

        for (TeacherEntity teacherEntity : teacherEntityList) {

            TeacherDto teacherDto = TeacherMapper.INSTANCE.teacherEntityToDto(teacherEntity);

            List<ClassDto> classDtoList = new ArrayList<>();

            for (ClassEntity classEntity : teacherEntity.getClassEntityList())

            {
                ClassDto classDto = ClassMapper.INSTANCE.classEntityToDto(classEntity);
             //  classDto.setTeacherDtoList(teacherDtoList);
                classDtoList.add(classDto);

            }
            List<SubjectDto> subjectDtoList = new ArrayList<>();

            for (SubjectEntity subjectEntity: teacherEntity.getSubjectEntityList()
                 ) {
                SubjectDto subjectDto= SubjectMapper.INSTANCE.subjectEntityToDto(subjectEntity);
                subjectDtoList.add(subjectDto);
            }
            teacherDto.setSubjectDtoList(subjectDtoList);
            teacherDto.setClassDtoList(classDtoList);
            teacherDtoList.add(teacherDto);
        }

        return teacherDtoList;
    }

    public List<TeacherDto> getTeachers(){
        List<TeacherEntity> teacherEntityList = teacherRepository.findAll();
        List<TeacherDto> teacherDtoList = new ArrayList<>();
        for (TeacherEntity teacherEntity: teacherEntityList
             ) {
            TeacherDto teacherDto = TeacherMapper.INSTANCE.teacherEntityToDto(teacherEntity);
            teacherDtoList.add(teacherDto);
        }
        return teacherDtoList;


    }

    @Override
    public TeacherClassDto addTeacherClass(TeacherClassDto teacherClassDto) {
        TeacherClassEntity entity = TeacherClassMapper.INSTANCE.teacherClassDtoToEntity(teacherClassDto);
        entity = teacherClassRepository.save(entity);
        return TeacherClassMapper.INSTANCE.teacherClassEntityToDto(entity);
    }
}

    //    private  TeacherDto mapEntityToDto(TeacherDto teacherDto){
//        TeacherDto responceDto = new TeacherDto();
//        responceDto.setName(teacherDto.getName());
//        responceDto.setAge(teacherDto.getAge());
//
//        return responceDto;
//    }
//
//
//    public List<ClassEntity> dtoToEntityList(List<ClassDto> classDtoList) {
//
//        List<ClassEntity> list = new ArrayList<ClassEntity>();
//        for (ClassDto classDto : classDtoList) {
//            list.add(classEntityToClassDto (classDto) );
//        }
//        return list;
//    }
//    public List<ClassDto> entityToDtoList(List<ClassEntity> classEntityList) {
//
//        List<ClassDto> list = new ArrayList<ClassDto>( classEntityList.size() );
//        for ( ClassEntity classEntity : classEntityList ) {
//            list.add( classDtoToEntity( classEntity ) );
//        }
//
//        return list;
//    }
//
//    public ClassEntity classEntityToClassDto(ClassDto classDto) {
//
//        ClassEntity responceEntity = new ClassEntity();
//
//        responceEntity.setId( classDto.getId() );
//        responceEntity.setName( classDto.getName() );
//
//        return responceEntity;
//    }
//
//    public ClassDto classDtoToEntity(ClassEntity classEntity) {
//
//        ClassDto responce = new ClassDto();
//
//        responce.setId( classEntity.getId() );
//        responce.setName( classEntity.getName() );
//
//        return responce;
//    }
//
//}


//        List<TeacherEntity> teacherEntityList = teacherRepository.findAll();
//
//        List<TeacherDto> teacherDtoList = new ArrayList<>();
//
//        for (TeacherEntity t: teacherEntityList) {
//            List<ClassEntity> classEntityList = t.getClassEntityList();
//            List<ClassDto> classDtoList = ClassMapper.INSTANCE.entityToDtoList(classEntityList);
//            TeacherDto teacherDto = TeacherMapper.INSTANCE.teacherDtoToEntity(t);
//            teacherDto.setClassDtoList(classDtoList);
//            teacherDtoList.add(teacherDto);
//
//        }
//        return teacherDtoList;


//    @Override
//    public List<TeacherDto> showTeacherClass() {
//
//
//        List<TeacherEntity> teacherEntityList = teacherRepository.findAll();
//
//        List<TeacherDto> teacherDtoList = new ArrayList<>();

//        for (TeacherEntity t : teacherEntityList) {
//            List<ClassEntity> classEntityList = t.g();
//            List<ClassDto> classDtoList = ClassMapper.INSTANCE.toDtoList(classEntityList);
//            TeacherDto teacherDto = TeacherMapper.INSTANCE.teacherDtoToEntity(t);
//            teacherDto.setClassDtos(classDtoList);
//            teacherDtoList.add(teacherDto);
//
//        }
//        return teacherDtoList;
//        return Optional.ofNullable(teacherClassRepository.findAll()).orElse(Collections.emptyList())
//                .stream()
//                .map(TeacherClassMapper.INSTANCE::teacherClassDtoToEntity)
//                .collect(Collectors.toList());


