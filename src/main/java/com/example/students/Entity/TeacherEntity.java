package com.example.students.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "teacher")
public class TeacherEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name = "age")
    private int age;
    @Column(name = "salary")
    private int salary;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_class_mapper", joinColumns = @JoinColumn (name = "teacher_id"),
                                                  inverseJoinColumns = @JoinColumn(name = "class_id"))
    @JsonBackReference
    private List<ClassEntity> classEntityList;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "teacherEntity")
    @JsonBackReference
    private List<SubjectEntity> subjectEntityList;

}
