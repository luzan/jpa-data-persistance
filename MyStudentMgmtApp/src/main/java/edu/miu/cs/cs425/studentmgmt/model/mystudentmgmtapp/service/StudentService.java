package edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.service;

import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.model.Student;

import java.util.List;

public interface StudentService {

    public abstract Student addNewStudent(Student student);
    public abstract List<Student> getAllStudents();
    public abstract  Student getStudentById(Long studentId);
    public abstract Student updateStudent(Student updatedStudent);

    public abstract void removeStudentById(Long studentId);
}
