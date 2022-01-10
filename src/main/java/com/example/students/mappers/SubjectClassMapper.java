package com.example.students.mappers;

import com.example.students.Entity.SubjectClassEntity;
import com.example.students.dtos.SubjectClassDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface SubjectClassMapper {
    SubjectClassMapper INSTANCE = Mappers.getMapper(SubjectClassMapper.class);

    SubjectClassEntity subjectClassDtoToEntity(SubjectClassDto subjectClassDto);
    SubjectClassDto subjectClassEntityToDto(SubjectClassEntity subjectClassEntity);
}
