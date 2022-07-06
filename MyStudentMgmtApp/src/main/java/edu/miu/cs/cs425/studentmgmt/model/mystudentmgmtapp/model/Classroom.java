package edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classroomId;

    private String buildingName;
    private String roomNumber;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "classroom")
    private Set<Student> students = new HashSet<>();

    public Classroom(String buildingName, String roomNumber, Set<Student> students) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
        this.students = students;
    }

    public Classroom() {

    }

    public Classroom(String buildingName, String roomNumber) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
