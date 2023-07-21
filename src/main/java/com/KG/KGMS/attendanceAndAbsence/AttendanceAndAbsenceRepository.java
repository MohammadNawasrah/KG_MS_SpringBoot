package com.KG.KGMS.attendanceAndAbsence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AttendanceAndAbsenceRepository extends JpaRepository<AttendanceAndAbsence, Long> {
    AttendanceAndAbsence findByStudentIdAndDate(Long studentId, String date);

    @Query(value = "SELECT date FROM attendance_and_absence ORDER BY date DESC LIMIT 1", nativeQuery = true)
    String findLastDate();
}