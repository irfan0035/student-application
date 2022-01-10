package com.example.students.Entity;

import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.security.PrivateKey;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "student_class_mapper")
public class StudentClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "student_id")
    private Long StudentId;

    @Column(name = "class_id")
    private Long classId;

}
