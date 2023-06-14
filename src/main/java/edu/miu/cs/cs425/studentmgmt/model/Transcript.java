package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transcripts")
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transcriptId;
    private String degreeTitle;

//    @OneToOne(mappedBy = "transcript")
//    private Student student;
    public Transcript() {
    }

    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Transcript(Integer id, String degreeTitle) {
        this.transcriptId = id;
        this.degreeTitle = degreeTitle;
    }

    public Integer getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(Integer transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

    @Override
    public String toString() {
        return "Transcript{" +
                "id=" + transcriptId +
                ", degreeTitle='" + degreeTitle + '\'' +
                '}';
    }
}
