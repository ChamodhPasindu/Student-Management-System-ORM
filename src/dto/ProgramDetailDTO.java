package dto;

import java.time.LocalDate;

public class ProgramDetailDTO {
    private String stId;
    private String programId;
    private LocalDate date;

    public ProgramDetailDTO(String stId, String programId, LocalDate date) {
        this.stId = stId;
        this.programId = programId;
        this.date = date;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
