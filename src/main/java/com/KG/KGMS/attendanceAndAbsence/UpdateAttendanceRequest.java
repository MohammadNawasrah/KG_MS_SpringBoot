package com.KG.KGMS.attendanceAndAbsence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAttendanceRequest {
    private Long studentId;
    private SchoolAttendance attendanceStatus;
}