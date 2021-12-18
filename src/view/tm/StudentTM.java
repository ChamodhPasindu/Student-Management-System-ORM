package view.tm;

public class StudentTM {
    private String stId;
    private String stName;

    public StudentTM(String stId, String stName) {
        this.stId = stId;
        this.stName = stName;
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
