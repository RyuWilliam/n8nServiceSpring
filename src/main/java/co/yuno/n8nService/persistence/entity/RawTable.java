package co.yuno.n8nService.persistence.entity;


import co.yuno.n8nService.persistence.enums.InfoSource;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "raw_table")
public class RawTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String source;

    private String merchent;

    @Column(length = 10000) // aumenta el límite
    private String snippet;

    private LocalDateTime date;

    private String Country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMerchent() {
        return merchent;
    }

    public void setMerchent(String merchent) {
        this.merchent = merchent;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
