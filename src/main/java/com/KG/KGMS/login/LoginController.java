package com.KG.KGMS.login;

import com.KG.KGMS.admin.Admin;
import com.KG.KGMS.admin.AdminService;
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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginForm) {
        String requestUsername = Validation.removeSpaces(loginForm.get("username"));
        String requestPassword = Validation.removeSpaces(loginForm.get("password"));
        String sqlUsername;
        String sqlPassword;
        String sqlName;
        boolean isAdmin = Validation.containsAtSymbol(requestPassword);
        System.out.println(requestUsername);
        System.out.println(requestPassword);
        if (isAdmin) {
            try {
                Admin admin = adminService.getAdminByUsername(requestUsername).orElse(null);
                sqlUsername = Validation.removeSpaces(admin.getUsername());
                sqlPassword = Validation.removeSpaces(admin.getPassword());
                sqlName = Validation.removeSpaces(admin.getName());
            } catch (Exception e) {
                return ResponseEntity.ok("not Found username" + requestUsername);
            }
        } else {
            try {
                Teacher teacher = teacherService.getTeacherByUsername(requestUsername).orElse(null);
                sqlUsername = Validation.removeSpaces(teacher.getTeacherUserName());
                sqlPassword = Validation.removeSpaces(teacher.getTeacherUserName());
                sqlName = Validation.removeSpaces(teacher.getTeacherName());
            } catch (Exception e) {
                System.out.println(e.toString());
                return ResponseEntity.ok("not Found User" + requestUsername);
            }
        }
        System.out.println(sqlUsername);
        System.out.println(sqlPassword);
        System.out.println("req");
        System.out.println(requestUsername);
        System.out.println(requestPassword);
        if (checkData(requestUsername, sqlUsername)) {
            if (checkData(requestPassword, sqlPassword)) {
                return ResponseEntity.ok("success login name" + sqlName);
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
