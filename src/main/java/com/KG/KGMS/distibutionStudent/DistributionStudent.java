package com.KG.KGMS.distibutionStudent;

import com.KG.KGMS.student.Student;
import com.KG.KGMS.student.StudentService;
import com.KG.KGMS.teacher.Teacher;
import com.KG.KGMS.teacher.TeacherService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionStudent {

    private final StudentService studentService;
    private final TeacherService teacherService;

    public DistributionStudent(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    public ResponseEntity<String> distribution() {
        try {
            List<Teacher> teachers = teacherService.getAllTeachers();
            List<Student> students = studentService.getAllStudents();
            int teachersCount = teacherService.getTeacherCount();
            int studentsCount = studentService.getCountOfStudent();

            int studentForeachTeacher = studentsCount / teachersCount;
            int count = 0;
            int temp = 0;
            for (int teacherIndex = 0; teacherIndex < teachersCount; teacherIndex++) {
                for (int studentIndex = temp; studentIndex < studentsCount; studentIndex++) {
                    studentService.updateTeacherId(students.get(studentIndex).getStudentId(),
                            teachers.get(teacherIndex).getTeacherId());
                    if (studentForeachTeacher == count) {
                        temp = temp + studentForeachTeacher + 1;
                        count = 0;
                        break;
                    }
                    count++;
                }

            }
            return ResponseEntity.ok("تم توزيع الطلبه بنجاح");
        } catch (Exception exception) {
            return ResponseEntity.ok("خطاء في البيانات");
        }
    }
}
