package com.KG.KGMS.attendanceAndAbsence;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceAndAbsenceController {
    private final AttendanceAndAbsenceService attendanceAndAbsenceService;



    public AttendanceAndAbsenceController(AttendanceAndAbsenceService attendanceAndAbsenceService) {
        this.attendanceAndAbsenceService = attendanceAndAbsenceService;
    }

    @GetMapping
    public List<AttendanceAndAbsence> getAllAttendances() {
        return attendanceAndAbsenceService.getAllAttendances();
    }
    @PostMapping("/updateAttendance")
    public ResponseEntity<String> updateAttendance(@RequestBody UpdateAttendanceRequest request) {
        try {
            attendanceAndAbsenceService.updateAttendance(request.getStudentId(), request.getAttendanceStatus());
            return ResponseEntity.ok("Attendance updated successfully");
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update attendance");
        }
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
