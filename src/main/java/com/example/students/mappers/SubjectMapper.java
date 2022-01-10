package com.example.students.mappers;

import com.example.students.Entity.SubjectClassEntity;
import com.example.students.Entity.SubjectEntity;
import com.example.students.dtos.SubjectClassDto;
import com.example.students.dtos.SubjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface SubjectMapper {
    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

    SubjectEntity subjectDtoToEntity(SubjectDto subjectDto);
    SubjectDto subjectEntityToDto(SubjectEntity subjectEntity);


}
