package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "program")
public class Program {
    @Id
    @Column(name = "program_id")
    private String id;

    @Column(name = "program_Name")
    private String name;

    private String duration;
    private BigDecimal fee;

    @ManyToMany(mappedBy = "programs", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    public Program(String id, String name, String duration, BigDecimal fee, List<Student> students) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
        this.students = students;
    }

    public Program() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Program{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                ", students=" + students +
                '}';
    }
}