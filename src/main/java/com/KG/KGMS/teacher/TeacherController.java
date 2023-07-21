package com.KG.KGMS.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.KG.KGMS.student.Student;
import com.KG.KGMS.student.StudentResponse;
import com.KG.KGMS.student.StudentService;

import java.util.List;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {
    private final TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/getTeachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/removeLogin")
    public void removeLogin(@RequestParam("teacherUserName") String teacherUserName) {
        teacherService.removeLogin(teacherUserName);
    }

    @GetMapping("/getIsLogin")
    public ResponseEntity<String> getIsLogin(@RequestParam("teacherUserName") String teacherUserName) {
        Teacher teacher = teacherService.getTeacherByUsername(teacherUserName).orElse(null);
        if (teacher != null) {
            boolean isLogin = teacher.isLogin();
            return ResponseEntity.ok(isLogin ? "true" : "false");
        } else {
            return ResponseEntity.ok("false");
        }
    }

    @GetMapping("/{id}")
    public Teacher getTeacherByUserName(@RequestParam String username) {
        System.out.println(username);
        return null;
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        System.out.println(teacher.getTeacherName());
        return teacherService.createTeacher(teacher);
    }

    @PostMapping("/getStudent")
    public ResponseEntity<Object> getStudentByTeacher(@RequestParam("teacherUserName") String teacherUserName) {
        try {
            Teacher teacher = teacherService.getTeacherByUsername(teacherUserName).orElse(null);
            List<Student> students = studentService.findAllByTeacherId(teacher.getTeacherId());
            StudentResponse studentResponse = new StudentResponse(students, teacher.getTeacherName());
            return ResponseEntity.ok(studentResponse);
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        teacher.setTeacherId(id);
        return teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}
