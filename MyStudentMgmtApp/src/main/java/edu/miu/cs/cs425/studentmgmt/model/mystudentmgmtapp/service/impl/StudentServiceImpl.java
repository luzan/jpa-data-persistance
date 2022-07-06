package edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.repository.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public Student addNewStudent(Student student) {
        var newStudent = studentRepository.save(student);
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        var students = studentRepository.findAll();
        return students;
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElse(null);
    }

    @Override
    public Student updateStudent(Student updatedStudent) {
        return studentRepository.save(updatedStudent);
    }

    @Override
    public void removeStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
        System.out.printf("Student with Student Id = %d id deleted!\n", studentId);
    }
}
