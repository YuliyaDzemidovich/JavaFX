package model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Work {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "worktype", nullable = false)
    private WorkType workType;
    @ManyToOne
    @JoinColumn(name = "fault")
    private Fault fault;
    @Column
    private Date startDate;
    @Column
    private Date finishDate;
    @Column
    private int cost;

    public Work() {

    }

    public Work(WorkType workType, Fault fault, Date startDate, Date finishDate, int cost) {
        this.workType = workType;
        this.fault = fault;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }

    public Fault getFault() {
        return fault;
    }

    public void setFault(Fault fault) {
        this.fault = fault;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
