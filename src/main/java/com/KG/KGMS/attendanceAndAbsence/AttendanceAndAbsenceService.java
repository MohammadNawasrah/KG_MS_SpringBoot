package com.KG.KGMS.attendanceAndAbsence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttendanceAndAbsenceService {
    private final AttendanceAndAbsenceRepository attendanceAndAbsenceRepository;

    @Autowired
    public AttendanceAndAbsenceService(AttendanceAndAbsenceRepository attendanceAndAbsenceRepository) {
        this.attendanceAndAbsenceRepository = attendanceAndAbsenceRepository;
    }

    public List<AttendanceAndAbsence> getAllAttendances() {
        return attendanceAndAbsenceRepository.findAll();
    }

    public AttendanceAndAbsence getAttendanceById(Long id) {
        return attendanceAndAbsenceRepository.findById(id).orElse(null);
    }

    public AttendanceAndAbsence createAttendance(AttendanceAndAbsence attendance) {
        return attendanceAndAbsenceRepository.save(attendance);
    }

    public AttendanceAndAbsence updateAttendance(AttendanceAndAbsence attendance) {
        return attendanceAndAbsenceRepository.save(attendance);
    }

    public void deleteAttendance(Long id) {
        attendanceAndAbsenceRepository.deleteById(id);
    }
}
