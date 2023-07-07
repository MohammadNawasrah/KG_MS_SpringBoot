package com.KG.KGMS.admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Additional query methods can be defined here if needed
}