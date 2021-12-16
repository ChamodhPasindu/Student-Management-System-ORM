package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "student")
public class Student {
    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "student_Name")
    private String studentName;
    private String nic;
    private String mobile;
    private String address;

    @ManyToMany
    private List<Program> programs = new ArrayList<>();

    public Student(String studentId, String studentName, String nic, String mobile, String address, List<Program> programs) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.nic = nic;
        this.mobile = mobile;
        this.address = address;
        this.programs = programs;
    }

    public Student() {

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", nic='" + nic + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", programs=" + programs +
                '}';
    }
}
