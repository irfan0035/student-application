package com.example.students.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "subject")
public class SubjectEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "teacher_id",insertable = false,updatable = false)
    private Long teacherId;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacherEntity;

    @ManyToMany(mappedBy = "subjectEntityList")
    private List<ClassEntity> classEntityList;


}
