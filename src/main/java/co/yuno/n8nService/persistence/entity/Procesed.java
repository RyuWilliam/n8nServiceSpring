package co.yuno.n8nService.persistence.entity;


import co.yuno.n8nService.persistence.enums.Phase;
import jakarta.persistence.*;

@Entity(name = "procesed")
public class Procesed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProcesed;


    @Column(length = 2000)
    private String summary;

    @Column(length = 100)
    private Phase phase;

    private String projectName;

    private String detailType;

    private String detail;

    public Integer getIdProcesed() {
        return idProcesed;
    }

    public void setIdProcesed(Integer idProcesed) {
        this.idProcesed = idProcesed;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDetailType() {
        return detailType;
    }

    public void setDetailType(String detailType) {
        this.detailType = detailType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
