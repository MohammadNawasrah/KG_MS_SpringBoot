package com.KG.KGMS.login;

import com.KG.KGMS.admin.Admin;
import com.KG.KGMS.admin.AdminService;
import com.KG.KGMS.student.StudentResponse;
import com.KG.KGMS.student.StudentService;
import com.KG.KGMS.teacher.Teacher;
import com.KG.KGMS.teacher.TeacherService;
import com.nawas.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, String> loginForm) {
        String requestUsername = Validation.removeSpaces(loginForm.get("username"));
        String requestPassword = Validation.removeSpaces(loginForm.get("password"));
        String sqlUsername;
        String sqlPassword;
        String sqlName;
        Long sqlId;
        boolean isAdmin = Validation.containsAtSymbol(requestPassword);
        System.out.println(requestUsername);
        System.out.println(requestPassword);
        if (isAdmin) {
            try {
                Admin admin = adminService.getAdminByUsername(requestUsername).orElse(null);
                sqlUsername = Validation.removeSpaces(admin.getUsername());
                sqlPassword = Validation.removeSpaces(admin.getPassword());
                sqlName = Validation.removeSpaces(admin.getName());
                sqlId = admin.getId();
            } catch (Exception e) {
                return ResponseEntity.ok("not Found username" + requestUsername);
            }
        } else {
            try {
                Teacher teacher = teacherService.getTeacherByUsername(requestUsername).orElse(null);
                sqlUsername = Validation.removeSpaces(teacher.getTeacherUserName());
                sqlPassword = Validation.removeSpaces(teacher.getTeacherUserName());
                sqlName = Validation.removeSpaces(teacher.getTeacherName());
                sqlId = teacher.getTeacherId();
            } catch (Exception e) {
                return ResponseEntity.ok("not Found User" + requestUsername);
            }
        }
        if (checkData(requestUsername, sqlUsername)) {
            if (checkData(requestPassword, sqlPassword) && isAdmin) {
                StudentResponse studentResponse = new StudentResponse(null, "success login admin" + sqlName);
                return ResponseEntity.ok(studentResponse);
            } else if (checkData(requestPassword, sqlPassword) && !isAdmin) {
                StudentResponse studentResponse = new StudentResponse(studentService.findAllByTeacherId(sqlId),
                        "success login name" + sqlName);
                return ResponseEntity.ok(studentResponse);
            }
            return ResponseEntity.ok("error in password for this name");
        }
        return ResponseEntity.ok("not found username" + requestUsername);
    }

    private boolean checkData(String responseUsername, String sqlUsername) {
        if (responseUsername.equals(responseUsername)) {
            return true;
        }
        return false;
    }
}
