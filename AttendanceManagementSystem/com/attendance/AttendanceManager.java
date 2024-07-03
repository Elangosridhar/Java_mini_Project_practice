package com.attendance;

import java.util.ArrayList;
import java.util.List;

public class AttendanceManager {
    private List<Student> students;
    private AttendanceRecord attendanceRecord;

    public AttendanceManager() {
        this.students = new ArrayList<>();
        this.attendanceRecord = new AttendanceRecord();
    }

    public void addStudent(String id, String name) {
        students.add(new Student(id, name));
    }

    public void markAttendance(String id, boolean isPresent) {
        attendanceRecord.markAttendance(id, isPresent);
    }

    public void displayAttendance() {
        for (Student student : students) {
            Boolean isPresent = attendanceRecord.getAttendance(student.getId());
            System.out.println("Student: " + student.getName() + " - Present: " + (isPresent != null ? isPresent : "No record"));
        }
    }
}
