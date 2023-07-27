package com.KG.KGMS.teacher;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public int getTeacherCount() {
        return getAllTeachers().size();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Optional<Teacher> getTeacherByUsername(String username) {
        return teacherRepository.findByTeacherUserName(username);
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public void removeLogin(String teacherUserName) {
        Teacher teacher = teacherRepository.findByTeacherUserName(teacherUserName).orElse(null);
        teacher.setLogin(false);
        teacherRepository.save(teacher);
    }

    public void restLoign() {
        List<Teacher> teachers = getAllTeachers();
        teachers.forEach((teacher) -> {
            teacher.setLogin(true);
            teacherRepository.save(teacher);
        });
    }

    public boolean getIsLogin(String teacherUserName) {
        Teacher teacher = teacherRepository.findByTeacherUserName(teacherUserName).orElse(null);
        return teacher.isLogin();
    }
}
