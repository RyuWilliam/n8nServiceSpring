package co.yuno.n8nService.persistence.entity;

import jakarta.persistence.*;

@Entity(name = "processed_raw")
public class ProcessedRaw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FK a processed
    @ManyToOne(optional = false)
    @JoinColumn(name = "processed_id")
    private Processed processed;

    // FK a raw_table
    @ManyToOne(optional = false)
    @JoinColumn(name = "raw_id")
    private RawTable rawTable;

    public ProcessedRaw() {
    }

    public ProcessedRaw(Processed processed, RawTable rawTable) {
        this.processed = processed;
        this.rawTable = rawTable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Processed getProcessed() {
        return processed;
    }

    public void setProcessed(Processed processed) {
        this.processed = processed;
    }

    public RawTable getRawTable() {
        return rawTable;
    }

    public void setRawTable(RawTable rawTable) {
        this.rawTable = rawTable;
    }
}
