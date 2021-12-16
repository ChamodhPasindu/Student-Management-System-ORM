package dto;

import java.math.BigDecimal;

public class ProgramDTO {
    private String id;
    private String name;
    private String duration;
    private BigDecimal fee;

    public ProgramDTO(String id, String name, String duration, BigDecimal fee) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
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

    @Override
    public String toString() {
        return "ProgramDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                '}';
    }
}
