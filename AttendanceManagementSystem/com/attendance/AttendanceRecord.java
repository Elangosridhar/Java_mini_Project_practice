package com.attendance;

import java.util.HashMap;
import java.util.Map;

public class AttendanceRecord {
    private Map<String, Boolean> attendanceMap;

    public AttendanceRecord() {
        this.attendanceMap = new HashMap<>();
    }

    public void markAttendance(String studentId, boolean isPresent) {
        attendanceMap.put(studentId, isPresent);
    }

    public Boolean getAttendance(String studentId) {
        return attendanceMap.get(studentId);
    }

    public Map<String, Boolean> getAllAttendance() {
        return attendanceMap;
    }
}
