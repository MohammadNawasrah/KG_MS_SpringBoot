package com.KG.KGMS.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Additional custom queries can be added here if needed
    @Query("SELECT s FROM Student s WHERE s.teacherId = :teacherId")
    List<Student> findAllByTeacherId(@Param("teacherId") Long teacherId);
}
