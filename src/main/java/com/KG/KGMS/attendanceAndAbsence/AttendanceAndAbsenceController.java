package com.KG.KGMS.attendanceAndAbsence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceAndAbsenceController {
    private final AttendanceAndAbsenceService attendanceAndAbsenceService;

    @Autowired
    public AttendanceAndAbsenceController(AttendanceAndAbsenceService attendanceAndAbsenceService) {
        this.attendanceAndAbsenceService = attendanceAndAbsenceService;
    }

    @GetMapping
    public List<AttendanceAndAbsence> getAllAttendances() {
        return attendanceAndAbsenceService.getAllAttendances();
    }

    @GetMapping("/{id}")
    public AttendanceAndAbsence getAttendanceById(@PathVariable Long id) {
        return attendanceAndAbsenceService.getAttendanceById(id);
    }

    @PostMapping
    public AttendanceAndAbsence createAttendance(@RequestBody AttendanceAndAbsence attendance) {
        return attendanceAndAbsenceService.createAttendance(attendance);
    }

    @PutMapping("/{id}")
    public AttendanceAndAbsence updateAttendance(@PathVariable Long id, @RequestBody AttendanceAndAbsence attendance) {
        attendance.setTimeId(id);
        return attendanceAndAbsenceService.updateAttendance(attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceAndAbsenceService.deleteAttendance(id);
    }
}
