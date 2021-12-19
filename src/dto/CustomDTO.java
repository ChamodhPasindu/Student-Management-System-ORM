package dto;

import java.time.LocalDate;

public class CustomDTO {
    private String stId;
    private String name;
    private String address;
    private String nic;
    private String mobile;
    private LocalDate date;

    public CustomDTO(String stId, String name, String address, String nic, String mobile, LocalDate date) {
        this.stId = stId;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.mobile = mobile;
        this.date = date;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
