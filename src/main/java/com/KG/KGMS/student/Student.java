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
    private String phoneNumber;

    @Column(name = "phone_number_second")
    private String phoneNumberSecond;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "n_id")
    private String nId;
}
