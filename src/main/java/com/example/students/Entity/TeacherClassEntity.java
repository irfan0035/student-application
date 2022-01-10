package com.example.students.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "teacher_class_mapper")
public class TeacherClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "class_id")
    private Long classId;

    @Column(name = "teacher_id")
    private Long teacherId;

//    @OneToOne(mappedBy = "teacherClassEntity")
////    @JoinColumn(name = "teacherClassId")
//    private SubjectEntity subjectEntity;


   // private Set<TeacherEntity> teacherEntities;

}
