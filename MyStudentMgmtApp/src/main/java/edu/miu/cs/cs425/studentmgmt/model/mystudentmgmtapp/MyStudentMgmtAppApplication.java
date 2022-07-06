package edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp;

import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {

	private StudentService studentService;

	public MyStudentMgmtAppApplication(StudentService studentService) {
		this.studentService = studentService;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Student Management!");
		Student anna = getStudent("000-61-0001", "Anna", "Lynn",
				"Smith", 3.45, LocalDate.of(2019, 5, 24));
		saveStudent(anna);
		Student randy = getStudent("000-61-0002", "Randy", "",
				"Oton", 3.6, LocalDate.of(2001, 2, 17));
		saveStudent(randy);
		printAllStudents();
		printStudentById(1L);
		printStudentById(10L);
		updateAndPrintStudentById(1L);
		deleteStudentById(2L);
		printAllStudents();
	}

	private Student getStudent(String studentNumber, String firstName, String middleName, String lastName, double cgpa,
							   LocalDate dateOfEnrollment) {
		return new Student(
				studentNumber,
				firstName,
				middleName,
				lastName,
				cgpa,
				dateOfEnrollment
		);
	}

	private void saveStudent(Student student) {
		this.studentService.addNewStudent(student);
		System.out.printf("Student record for %s is created\n", student.getLastName());
	}

	private void printAllStudents() {
		var students = this.studentService.getAllStudents();
		students.forEach(System.out::println);
	}

	private void printStudentById(Long studentId) {
		var student = this.studentService.getStudentById(studentId);
		if(student != null) {
			System.out.println(student);
		} else {
			System.out.printf("Student with Student Id = %d not found!\n", studentId);
		}
	}

	private void updateAndPrintStudentById(Long studentId) {
		var student = this.studentService.getStudentById(studentId);
		student.setFirstName("Banna");
		var updatedStudent = this.studentService.updateStudent(student);
		System.out.println(updatedStudent);
	}

	private void deleteStudentById(Long studentId) {
		this.studentService.removeStudentById(studentId);
	}
}
