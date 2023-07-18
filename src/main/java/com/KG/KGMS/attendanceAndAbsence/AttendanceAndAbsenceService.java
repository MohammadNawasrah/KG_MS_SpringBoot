package com.KG.KGMS.attendanceAndAbsence;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceAndAbsenceService {
    private final AttendanceAndAbsenceRepository attendanceAndAbsenceRepository;


    public AttendanceAndAbsenceService(AttendanceAndAbsenceRepository attendanceAndAbsenceRepository) {
        this.attendanceAndAbsenceRepository = attendanceAndAbsenceRepository;
    }

    public List<AttendanceAndAbsence> getAllAttendances() {
        return attendanceAndAbsenceRepository.findAll();
    }

    public AttendanceAndAbsence getAttendanceById(Long id) {
        return attendanceAndAbsenceRepository.findById(id).orElse(null);
    }
    public AttendanceAndAbsence findByStudentIdAndDate(Long id,String date) {
        return attendanceAndAbsenceRepository.findByStudentIdAndDate(id,date);
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

    public void updateAttendance(Long studentId, SchoolAttendance attendanceStatus) {
        AttendanceAndAbsence attendance =findByStudentIdAndDate(studentId,LocalDate.now().toString());

        if (attendance != null){

            if (attendance.getDate().equals(LocalDate.now().toString())) {

                deleteAttendance(attendance.getTimeId());
            }}
        attendance = new AttendanceAndAbsence();
        attendance.setSchoolAttendance(attendanceStatus);
        attendance.setDate(LocalDate.now().toString());
        attendance.setStudentId(studentId);
        attendanceAndAbsenceRepository.save(attendance);
    }
}
