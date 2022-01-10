package com.example.students.mappers;

import com.example.students.Entity.ClassEntity;
import com.example.students.Entity.TeacherEntity;
import com.example.students.dtos.ClassDto;
import com.example.students.dtos.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClassMapper {
    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    ClassEntity classDtoToEntity(ClassDto classDto);
    ClassDto classEntityToDto(ClassEntity classEntity);
//
//    List<ClassEntity> dtoToEntityList(List<ClassDto> classDtoList);
//   List<ClassDto> entityToDtoList(List<ClassEntity> classEntityList);

}
