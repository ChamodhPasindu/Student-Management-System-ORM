package entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "program_detail")
public class ProgramDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;
    private LocalDate date;

    public ProgramDetail(Student student, Program program, LocalDate date) {
        this.student = student;
        this.program = program;
        this.date = date;
    }

    public ProgramDetail(int id, Student student, Program program, LocalDate date) {
        this.id = id;
        this.student = student;
        this.program = program;
        this.date = date;
    }

    public ProgramDetail() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ProgramDetail{" +
                "id=" + id +
                ", student=" + student +
                ", program=" + program +
                ", date=" + date +
                '}';
    }
}
