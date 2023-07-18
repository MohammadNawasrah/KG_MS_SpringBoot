package com.KG.KGMS.admin;

import com.KG.KGMS.distibutionStudent.DistributionStudent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/admins", method = RequestMethod.GET)
public class AdminController {
    private final AdminService adminService;
    private final DistributionStudent distributionStudent;

    public AdminController(AdminService adminService, DistributionStudent distributionStudent) {
        this.adminService = adminService;
        this.distributionStudent = distributionStudent;
    }

    @GetMapping("/getAllAdmins")
    public List<Admin> getAllAdmins() {
        System.out.println("getAllAdmins");
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/addAdmin")
    public Admin createAdmin(@RequestBody Admin admin) {
        System.out.println("add admin");
        return adminService.createAdmin(admin);
    }

    @PostMapping("/distribution")
    public ResponseEntity<String> distributionStudent() {
        return distributionStudent.distribution();
    }

    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        admin.setId(id);
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }
}
