package entity;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProgramDetail>programDetails = new ArrayList<>();

    public Student(String studentId, String studentName, String nic, String mobile, String address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.nic = nic;
        this.mobile = mobile;
        this.address = address;
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

    public List<ProgramDetail> getProgramDetails() {
        return programDetails;
    }

    public void setProgramDetails(List<ProgramDetail> programDetails) {
        this.programDetails = programDetails;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", nic='" + nic + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", programDetails=" + programDetails +
                '}';
    }
}
