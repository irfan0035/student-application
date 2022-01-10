package com.example.students.mappers;

import com.example.students.Entity.ClassEntity;
import com.example.students.Entity.TeacherEntity;
import com.example.students.dtos.ClassDto;
import com.example.students.dtos.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherEntity teacherDtoToEntity(TeacherDto teacherDto);
    TeacherDto teacherEntityToDto(TeacherEntity teacherEntity);

  //  List<ClassEntity>
//    List<TeacherEntity> toEntityList(List<TeacherDto> teacherDtoList);
//    List<TeacherDto> toDtoList(List<TeacherEntity> teacherEntityList);
}
