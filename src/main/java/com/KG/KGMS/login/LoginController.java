package com.KG.KGMS.login;

import com.KG.KGMS.admin.Admin;
import com.KG.KGMS.admin.AdminService;
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

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, String> loginForm) {
        String requestUsername = Validation.removeSpaces(loginForm.get("username"));
        String requestPassword = Validation.removeSpaces(loginForm.get("password"));
        String sqlUsername;
        String sqlPassword;
        String sqlName;

        Admin admin = adminService.getAdminByUsername(requestUsername).orElse(null);

        if (admin != null) {
            sqlUsername = Validation.removeSpaces(admin.getUsername());
            sqlPassword = Validation.removeSpaces(admin.getPassword());
            sqlName = Validation.removeSpaces(admin.getName());
            if (checkData(requestUsername, sqlUsername)) {
                if (checkData(requestPassword, sqlPassword)) {
                    return ResponseEntity.ok("success login admin" + sqlName);
                }
                return ResponseEntity.ok("error in password for this name" + sqlName);
            }
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
