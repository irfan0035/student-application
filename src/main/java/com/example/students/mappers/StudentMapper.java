package com.example.students.mappers;


import com.example.students.Entity.StudentEntity;
import com.example.students.dtos.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentEntity toEntity(StudentDto studentDto);
    StudentDto toDto(StudentEntity studentEntity);
}
