package edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "transcripts")
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transcriptId;
    @Column(nullable = false)
    @NotNull(message = "Degree Title cannot be null!")
    private String degreeTitle;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    public Transcript() {
        this(null);
    }
    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Transcript(String degreeTitle, Student student) {
        this.degreeTitle = degreeTitle;
        this.student = student;
    }

    public Long getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(Long transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "transcriptId=" + transcriptId +
                ", degreeTitle='" + degreeTitle + '\'' +
                '}';
    }
}
