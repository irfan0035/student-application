package com.example.students.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "subject_class_mapper")
public class SubjectClassEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "subject_id")
    private Long SubjectId;

    @Column(name = "class_id")
    private Long classId;
}
