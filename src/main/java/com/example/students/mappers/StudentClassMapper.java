package com.example.students.mappers;

import com.example.students.Entity.StudentClassEntity;
import com.example.students.dtos.StudentClassDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface StudentClassMapper {
    StudentClassMapper INSTANCE = Mappers.getMapper(StudentClassMapper.class);

    StudentClassEntity studentClassDtoToEntity(StudentClassDto studentClassDto);
    StudentClassDto studentClassEntityToDto(StudentClassEntity studentClassEntity);
}
