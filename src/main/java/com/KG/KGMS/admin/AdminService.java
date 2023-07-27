package com.KG.KGMS.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KG.KGMS.student.StudentService;
import com.KG.KGMS.studentTeacher.StudentTeacher;
import com.KG.KGMS.teacher.TeacherService;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public StudentTeacher getAllTeacherStudent() {
        StudentTeacher studentTeacher = new StudentTeacher(teacherService.getAllTeachers(),
                studentService.getAllStudents());
        return studentTeacher;
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Optional<Admin> getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
