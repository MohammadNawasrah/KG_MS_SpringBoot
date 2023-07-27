package com.KG.KGMS.studentTeacher;

import java.util.List;
import com.KG.KGMS.teacher.Teacher;
import com.KG.KGMS.student.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentTeacher {
    private List<Teacher> teachers;
    private List<Student> students;

    public StudentTeacher(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
    }
}
