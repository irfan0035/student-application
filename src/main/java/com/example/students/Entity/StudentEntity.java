package com.example.students.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import liquibase.pro.packaged.E;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "student")
public class StudentEntity extends AuditEntity{
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_class_mapper", joinColumns = @JoinColumn (name = "student_id"),
                                        inverseJoinColumns = @JoinColumn(name = "class_id"))
    private List<ClassEntity> classEntityList1;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "studentEntity")
    private List<AttendanceEntity> attendanceEntity;



}
