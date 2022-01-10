package com.example.students.Service.impl;

import com.example.students.Entity.AttendanceEntity;
import com.example.students.Entity.ClassEntity;
import com.example.students.Entity.StudentClassEntity;
import com.example.students.Entity.StudentEntity;
import com.example.students.Exception.ResourceExist;
import com.example.students.Exception.ResourseNotFound;
import com.example.students.Service.StudentService;
import com.example.students.dtos.AttendanceDto;
import com.example.students.dtos.ClassDto;
import com.example.students.dtos.StudentClassDto;
import com.example.students.dtos.StudentDto;
import com.example.students.mappers.AttendanceMapper;
import com.example.students.mappers.ClassMapper;
import com.example.students.mappers.StudentClassMapper;
import com.example.students.mappers.StudentMapper;
import com.example.students.repositories.AttendanceRepository;
import com.example.students.repositories.StudentClassRepository;
import com.example.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentClassRepository studentClassRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    //    public StudentDto addStudent(StudentDto studentDto)throws  ResourceExist{
//        return null;
//    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) throws ResourceExist{
        StudentEntity entity = studentRepository.getStudentByName(studentDto.getName());
//        StudentEntity entity1 = studentRepositories.findById(studentDto.getId());
        if(entity != null) {
            throw new ResourceExist("Student name Already Exist");
        }
        entity = StudentMapper.INSTANCE.toEntity(studentDto);
        entity = studentRepository.save(entity);

        return StudentMapper.INSTANCE.toDto(entity);
    }

    @Override
    public List<StudentDto> getStudents() {
//        return Optional.ofNullable(studentRepository.findAll()).orElse(Collections.emptyList())
//                .stream()
//                .map(StudentMapper.INSTANCE::toDto)
//                .peek(studentDto ->
//                .collect(Collectors.toList());

        List<StudentEntity> studentEntityList = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (StudentEntity studentEntity:studentEntityList
             ) {
           StudentDto studentDto = StudentMapper.INSTANCE.toDto(studentEntity);

            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }

//    public StudentDto getStudent(){
//        StudentEntity studentEntity = new StudentEntity();
//        StudentDto studentDto = StudentMapper.INSTANCE.toDto(studentEntity);
//        return  studentDto;
//    }

    @Override
    public AttendanceDto addAttendance(AttendanceDto attendanceDto) {

        StudentEntity studentEntity = studentRepository.findById(attendanceDto.getStudentId()).orElse(null);
        if(studentEntity == null)
            throw new ResourseNotFound("Student-Id is Invalid");

        AttendanceEntity attendanceEntity = AttendanceMapper.INSTANCE.attendanceDtoToEntity(attendanceDto);
        attendanceEntity.setStudentEntity(studentEntity);
        attendanceEntity = attendanceRepository.save(attendanceEntity);
        return AttendanceMapper.INSTANCE.attendanceEntityToDto(attendanceEntity);

    }

    @Override
    public List<AttendanceDto> getAttendance() {
        return Optional.ofNullable(attendanceRepository.findAll()).orElse(Collections.emptyList())
                .stream()
                .map(AttendanceMapper.INSTANCE::attendanceEntityToDto)
                .collect(Collectors.toList());

//        List<AttendanceDto> attendanceDtoList = new ArrayList<>();
//        List<AttendanceEntity> attendanceEntityList = attendanceRepository.findAll();
    }

    @Override
    public StudentClassDto addStudentClass(StudentClassDto studentClassDto) throws ResourceExist {
        StudentClassEntity entity; //= studentClassRepository.getStudnetById(studentClassDto.getStudentId());
//        if(entity == null){
//            throw new ResourceExist("Student Id is Already Exist");
//        }
        entity = StudentClassMapper.INSTANCE.studentClassDtoToEntity(studentClassDto);
        entity = studentClassRepository.save(entity);
        return StudentClassMapper.INSTANCE.studentClassEntityToDto(entity);
    }

    @Override
    public List<StudentClassDto> getStudentClass() {
         List s = Optional.ofNullable(studentClassRepository.findAll())
                 .orElse(Collections.emptyList())
                 .stream()
                 .map(StudentClassMapper.INSTANCE::studentClassEntityToDto)
                 .collect(Collectors.toList());
        return s;
    }

    public List<StudentDto> getStudentDetails(){
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (StudentEntity studentEntity: studentEntityList
             ) {
                StudentDto studentDto = StudentMapper.INSTANCE.toDto(studentEntity);
                List<ClassDto> classDtoList = new ArrayList<>();
                for (ClassEntity classEntity:studentEntity.getClassEntityList1()
                 ) {
                    ClassDto classDto = ClassMapper.INSTANCE.classEntityToDto(classEntity);
                    classDtoList.add(classDto);
            }
              List<AttendanceDto> attendanceDtoList = new ArrayList<>();
            for (AttendanceEntity attendanceEntity:studentEntity.getAttendanceEntity()
                 ) {
                AttendanceDto attendanceDto = AttendanceMapper.INSTANCE.attendanceEntityToDto(attendanceEntity);
                attendanceDtoList.add(attendanceDto);
            }
//                List<AttendanceDto> attendanceDtoList = new ArrayList<>();
//            for (AttendanceEntity attandanceEntity: studentEntity.getAttendanceEntityList()
//                 ) {
//                AttendanceDto attendanceDto = AttendanceMapper.INSTANCE.attendanceEntityToDto(attandanceEntity);
//                attendanceDtoList.add(attendanceDto);
//
//            }
                studentDto.setClassDtoList(classDtoList);
                studentDto.setAttendanceDtoList(attendanceDtoList);
                studentDtoList.add(studentDto);
//               studentDtoList.add(studentDto);

        }
        return studentDtoList;
    }
//    @Override
//    public StudentDto getStudentByName(String name){
//        return null;
//    }
//
//    @Override
//    public List<StudentDto> getStudents() {
//        return null;
//    }
}
