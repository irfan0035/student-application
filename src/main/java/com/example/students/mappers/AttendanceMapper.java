package com.example.students.mappers;

import com.example.students.Entity.AttendanceEntity;
import com.example.students.Entity.ClassEntity;
import com.example.students.dtos.AttendanceDto;
import com.example.students.dtos.ClassDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AttendanceMapper {
    AttendanceMapper INSTANCE = Mappers.getMapper(AttendanceMapper.class);

    AttendanceEntity attendanceDtoToEntity(AttendanceDto attendanceDto);

//    @Mapping(ignore = true, target = "studentId")
    AttendanceDto attendanceEntityToDto(AttendanceEntity attendanceEntity);
}
