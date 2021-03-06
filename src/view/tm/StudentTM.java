package view.tm;

import java.time.LocalDate;

public class StudentTM {
    private String stId;
    private String stName;
    private String address;
    private String nic;
    private String mobile;
    private LocalDate date;

    public StudentTM(String stId, String stName, String address, String nic, String mobile, LocalDate date) {
        this.stId = stId;
        this.stName = stName;
        this.address = address;
        this.nic = nic;
        this.mobile = mobile;
        this.date = date;
    }

    public StudentTM(String stId, String stName) {
        this.stId = stId;
        this.stName = stName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }
}
