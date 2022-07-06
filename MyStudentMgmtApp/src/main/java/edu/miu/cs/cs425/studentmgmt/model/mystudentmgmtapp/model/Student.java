package edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(nullable = false)
    @NotNull(message="Student Number cannot be null!")
    @NotEmpty(message="Student Number cannot be empty!")
    @NotBlank(message="Student Number cannot be blank spaces!")
    private String studentNumber;
    @Column(nullable = false)
    @NotNull(message="First name cannot be null!")
    @NotEmpty(message="First name cannot be empty!")
    @NotBlank(message="First name cannot be blank spaces!")
    private String firstName;
    @Column(nullable = true)
    private String middleName;
    @Column(nullable = false)
    @NotNull(message="Last name cannot be null!")
    @NotEmpty(message="Last name cannot be empty!")
    @NotBlank(message="Last name cannot be blank spaces!")
    private String lastName;
    @Column(nullable = true)
    private double cgpa;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Transcript> transcripts = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name="student_classroom",
            joinColumns=@JoinColumn(name="student_id"),
            inverseJoinColumns=@JoinColumn(name="classroom_id"))
    private Classroom classroom;

    private LocalDate dateOfEnrollment;

    public Student() {
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, double cgpa, LocalDate dateOfEnrollment) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, double cgpa, Set<Transcript> transcripts, LocalDate dateOfEnrollment) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.transcripts = transcripts;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, double cgpa, Set<Transcript> transcripts, Classroom classroom, LocalDate dateOfEnrollment) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.transcripts = transcripts;
        this.classroom = classroom;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Set<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(Set<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

    public  void addTranscript(Transcript transcript) {
        this.transcripts.add(transcript);
    }
    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa=" + cgpa +
                ", dateOfEnrollment=" + dateOfEnrollment +
                '}';
    }

}
