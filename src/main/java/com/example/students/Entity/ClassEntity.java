package com.example.students.Entity;

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
@Table(name = "class")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "classEntityList",fetch = FetchType.LAZY)
    private List<TeacherEntity> teacherEntityList;

    @ManyToMany(mappedBy = "classEntityList1",fetch = FetchType.LAZY)
    private List<StudentEntity> studentEntityList;

    @ManyToMany
    @JoinTable(name = "subject_class_mapper",joinColumns = @JoinColumn(name = "class_id") ,  inverseJoinColumns =@JoinColumn(name = "subject_id"))
    private List<SubjectEntity> subjectEntityList;

}
