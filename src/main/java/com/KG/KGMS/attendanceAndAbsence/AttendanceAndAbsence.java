package com.KG.KGMS.attendanceAndAbsence;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "attendance_and_absence")
public class AttendanceAndAbsence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_id")
    private Long timeId;

    @Column(name = "date")
    private String date;

    @Column(name = "school_attendance")
    @Enumerated(EnumType.STRING)
    private SchoolAttendance schoolAttendance;

    @Column(name = "student_id")
    private Long studentId;

}
