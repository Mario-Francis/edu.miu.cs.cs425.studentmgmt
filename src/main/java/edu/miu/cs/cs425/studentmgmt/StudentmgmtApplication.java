package edu.miu.cs.cs425.studentmgmt;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Course;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class StudentmgmtApplication implements CommandLineRunner {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TranscriptService transcriptService;

    public static void main(String[] args) {
        SpringApplication.run(StudentmgmtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World");


        var student = new Student(
                "000-61-0004",
                "Klaus",
                "Michael",
                "Salvatore",
                3.45,
                LocalDate.of(2019, 5, 24));
        var transcript = new Transcript("BS Mechanical Engineering");
        var classroom = new Classroom("McLaughlin building", "M106");
        var course1 = new Course("CS402", "Modern Programming Practices");
        var course2 = new Course("CS426", "Software Engineering");
        var course3 = new Course("CS326", "FPP");


        //saveStudent(student, transcript, classroom);
        student.setTranscript(transcript);
        student.setClassroom(classroom);
        saveStudent(student, List.of(course1, course2, course3));
    }

    void saveStudent(Student student) {
        var savedStudent = studentService.add(student);
        System.out.println("=== SAVED STUDENT ===");
        System.out.println(savedStudent);
    }

    void saveStudent(Student student, Transcript transcript) {
        student.setTranscript(transcript);
        //transcript.setStudent(student);
        var savedStudent = studentService.add(student);
        System.out.println("=== SAVED STUDENT WITH TRANSCRIPT===");
        System.out.println(savedStudent);
    }

    void saveStudent(Student student, Transcript transcript, Classroom classroom) {
        student.setTranscript(transcript);
        student.setClassroom(classroom);
        var savedStudent = studentService.add(student);
        System.out.println("=== SAVED STUDENT WITH TRANSCRIPT AND CLASSROOM===");
        System.out.println(savedStudent);
    }

    void saveStudent(Student student, List<Course> courses) {
        student.setCourses(courses);
        var savedStudent = studentService.add(student);
        System.out.println("=== SAVED STUDENT WITH COURSES===");
        System.out.println(savedStudent);
    }

}
