package com.KG.KGMS.teacher;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByTeacherUserName(String username);
    // Additional custom queries can be added here if needed
}
