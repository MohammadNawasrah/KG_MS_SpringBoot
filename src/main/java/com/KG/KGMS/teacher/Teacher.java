package com.KG.KGMS.teacher;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "teacher_username")
    private String teacherUserName;

    @Column(name = "teacher_password")
    private String teacherPassword;

    @Column(name = "teacher_type")
    private String teacherType;
    @Column(name = "is_login", columnDefinition = "boolean default true")
    private boolean isLogin;

}
