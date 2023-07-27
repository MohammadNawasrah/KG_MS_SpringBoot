package com.KG.KGMS.attendanceAndAbsence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.KG.KGMS.teacher.TeacherService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceAndAbsenceController {
    private final AttendanceAndAbsenceService attendanceAndAbsenceService;
    @Autowired
    private TeacherService teacherService;

    public AttendanceAndAbsenceController(AttendanceAndAbsenceService attendanceAndAbsenceService) {
        this.attendanceAndAbsenceService = attendanceAndAbsenceService;
    }

    @GetMapping
    public List<AttendanceAndAbsence> getAllAttendances() {
        return attendanceAndAbsenceService.getAllAttendances();
    }

    @GetMapping("/lastDateUpdate")
    public void getLastDateUpdate() {
        try {
            int compareDate = LocalDate.now().toString().compareTo(attendanceAndAbsenceService.getLastDate());
            if (compareDate > 0) {
                teacherService.restLoign();
            }
        } catch (Exception e) {
            System.out.println("-======================================");
            System.out.println(e.toString());
            System.out.println("-======================================");

        }
    }

    @PostMapping("/updateAttendance")
    public ResponseEntity<String> updateAttendance(@RequestBody UpdateAttendanceRequest request,
            @RequestParam("name") String teacherUserName) {
        try {
            if (teacherService.getIsLogin(teacherUserName)) {
                attendanceAndAbsenceService.updateAttendance(request.getStudentId(), request.getAttendanceStatus());
                return ResponseEntity.ok("Attendance updated successfully");
            }
            return ResponseEntity.ok("Not login Teacher");
        } catch (Exception e) {
            System.out.println("-======================================");
            System.out.println(e.toString());
            System.out.println("-======================================");
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
