package com.KG.KGMS.student;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "dateOfBarthday")
    private String dateOfBarthday;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "teacher_id")
    private Long teacherId;

    // Constructors, getters, and setters
}
