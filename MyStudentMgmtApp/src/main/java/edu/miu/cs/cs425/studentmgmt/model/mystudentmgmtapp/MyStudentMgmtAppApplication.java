package edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp;

import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.service.ClassroomService;
import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.service.StudentService;
import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.service.TranscriptService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {

	private StudentService studentService;
	private TranscriptService transcriptService;
	private ClassroomService classroomService;

	public MyStudentMgmtAppApplication(StudentService studentService, TranscriptService transcriptService, ClassroomService classroomService) {
		this.studentService = studentService;
		this.transcriptService = transcriptService;
		this.classroomService = classroomService;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Student Management!");

		Classroom m105 = new Classroom("McLaughlin Building", "M115");
		Classroom m106 = new Classroom("McLaughlin Building", "M116");

		saveClassroom(m105);
		saveClassroom(m106);

		Student anna = getStudent("000-61-0001", "Anna", "Lynn",
				"Smith", 3.45, LocalDate.of(2019, 5, 24));
		Student randy = getStudent("000-61-0002", "Randy", "",
				"Oton", 3.6, LocalDate.of(2001, 2, 17));

		saveStudent(anna);
		saveStudent(randy);

		assignClassroomToStudent(m105, anna);
		assignClassroomToStudent(m106, randy);


		Transcript bs = new Transcript("BS in Computer Science", anna);
		Transcript ms = new Transcript("MS in Computer Science", randy);

		saveTranscript(bs);
		saveTranscript(ms);

		// Task 1 test
//		printAllStudents();
//		printStudentById(1L);
//		printStudentById(10L);
//		updateAndPrintStudentById(1L);
//		deleteStudentById(2L);
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

	private void assignClassroomToStudent(Classroom classroom, Student student) {
		var newStudent = this.studentService.getStudentById(student.getStudentId());
		newStudent.setClassroom(classroom);
		var updatedStudent = this.studentService.updateStudent(newStudent);
		System.out.printf("Classroom at %s assigned to Student with Student Id: %d\n",classroom.getBuildingName(), updatedStudent.getStudentId());
	}

	private void deleteStudentById(Long studentId) {
		this.studentService.removeStudentById(studentId);
	}

	private void saveClassroom(Classroom classroom){
		this.classroomService.saveClassroom(classroom);
	}

	private void saveTranscript(Transcript transcript) {
		this.transcriptService.saveTranscript(transcript);
	}


}
