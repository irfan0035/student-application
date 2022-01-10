package com.example.students.mappers;

import com.example.students.Entity.ClassEntity;
import com.example.students.Entity.MarksEntity;
import com.example.students.dtos.ClassDto;
import com.example.students.dtos.MarksDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface MarkMapper {
    MarkMapper INSTANCE = Mappers.getMapper(MarkMapper.class);

    MarksEntity markDtoToEntity(MarksDto marksDto);
    MarksDto markEntityToDto(MarksEntity marksEntity);
}
