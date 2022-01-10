package com.example.students.Entity;

import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "attendance")
public class AttendanceEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "student_id",insertable = false,updatable = false)
    private Long studentId;

    @Column(name = "date")
    private Date date;

    @Column(name = "attendance")
    private String attendance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;
}
