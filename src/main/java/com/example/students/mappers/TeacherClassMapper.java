package com.example.students.mappers;

import com.example.students.Entity.TeacherClassEntity;
import com.example.students.dtos.TeacherClassDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface TeacherClassMapper {
    TeacherClassMapper INSTANCE = Mappers.getMapper(TeacherClassMapper.class);

    TeacherClassEntity teacherClassDtoToEntity(TeacherClassDto teacherClassDto);
    TeacherClassDto teacherClassEntityToDto(TeacherClassEntity teacherClassEntity);
}
