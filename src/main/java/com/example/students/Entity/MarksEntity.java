package com.example.students.Entity;

import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "marks")
public class MarksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "student_id",insertable = false,updatable = false)
    private Long studentId;

    @Column(name = "subject_id",insertable = false,updatable = false)
    private Long subjectId;

    @Column(name = "class_id",insertable = false,updatable = false)
    private Long classId;

    @Column(name = "mark" ,nullable = true)
    private int mark;

    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;
    @OneToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subjectEntity;
    @OneToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;

}
