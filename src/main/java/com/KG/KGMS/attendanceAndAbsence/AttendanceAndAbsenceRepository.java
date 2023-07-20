package com.KG.KGMS.attendanceAndAbsence;

import com.KG.KGMS.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AttendanceAndAbsenceRepository extends JpaRepository<AttendanceAndAbsence, Long> {
    AttendanceAndAbsence findByStudentIdAndDate(Long studentId, String date);
}