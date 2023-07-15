package com.KG.KGMS.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/teachers", method = RequestMethod.GET)
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/getTeachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    // @GetMapping("/{id}")
    // public Teacher getTeacherById(@PathVariable Long id) {
    // return teacherService.getTeacherById(id);
    // }

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
