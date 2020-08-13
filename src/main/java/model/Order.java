package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "repair_order")
public class Order {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private ServiceAdvisor serviceAdvisor;
    @Column
    private Date createdDate;
    @Column
    private Date plannedFinishDate;
    @Column
    private Date actualFinishDate;
    @Column
    private int totalSum;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order() {

    }

    public Order(Vehicle vehicle, Client client, ServiceAdvisor serviceAdvisor, Date createdDate, Date plannedFinishDate, Date actualFinishDate, int totalSum, OrderStatus status) {
        this.vehicle = vehicle;
        this.client = client;
        this.serviceAdvisor = serviceAdvisor;
        this.createdDate = createdDate;
        this.plannedFinishDate = plannedFinishDate;
        this.actualFinishDate = actualFinishDate;
        this.totalSum = totalSum;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ServiceAdvisor getServiceAdvisor() {
        return serviceAdvisor;
    }

    public void setServiceAdvisor(ServiceAdvisor serviceAdvisor) {
        this.serviceAdvisor = serviceAdvisor;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getPlannedFinishDate() {
        return plannedFinishDate;
    }

    public void setPlannedFinishDate(Date plannedFinishDate) {
        this.plannedFinishDate = plannedFinishDate;
    }

    public Date getActualFinishDate() {
        return actualFinishDate;
    }

    public void setActualFinishDate(Date actualFinishDate) {
        this.actualFinishDate = actualFinishDate;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
