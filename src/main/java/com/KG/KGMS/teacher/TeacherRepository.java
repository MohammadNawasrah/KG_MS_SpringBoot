package com.KG.KGMS.teacher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    // Additional custom queries can be added here if needed
}
