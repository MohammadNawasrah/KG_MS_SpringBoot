package com.KG.KGMS.student;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentResponse {
    private List<Student> students;
    private String requestUsername;

    public StudentResponse(List<Student> students, String requestUsername) {
        this.students = students;
        this.requestUsername = requestUsername;
    }

}