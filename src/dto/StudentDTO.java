package dto;

public class StudentDTO {
    private String stId;
    private String name;
    private String address;
    private String nic;
    private String mobile;

    public StudentDTO(String stId, String name, String address, String nic, String mobile) {
        this.stId = stId;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.mobile = mobile;
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

    @Override
    public String toString() {
        return "StudentDTO{" +
                "stId='" + stId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
