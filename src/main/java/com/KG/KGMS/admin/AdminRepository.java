package com.KG.KGMS.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Additional query methods can be defined here if needed
    Optional<Admin> findByUsername(String username);
}