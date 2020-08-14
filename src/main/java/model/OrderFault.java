package model;

import javax.persistence.*;

/**
 * This class represents status of each fault found in one particular {@link Order}.
 * Each fault found has order it belongs. Fault also may have a diagnostics made, but that's not necessary.
 * Each fault has status set, depending whether it was found during diagnostics or claimed initially by client,
 * whether it needs to be fixed or not (client may refuse fixing it), whether it was fixed or not. There is
 * also fault status, when the fault was claimed by client, but wasn't found.
 * @see model.FaultStatus
 */
@Entity
public class OrderFault {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "repair_order", nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "fault")
    private Fault fault;
    @OneToOne
    @JoinColumn(name = "diagnostics")
    private Diagnostics diagnostics;
    @Enumerated(EnumType.STRING)
    private FaultStatus faultStatus;

    public OrderFault () {

    }

    public OrderFault(Order order, Fault fault, Diagnostics diagnostics, FaultStatus faultStatus) {
        this.order = order;
        this.fault = fault;
        this.diagnostics = diagnostics;
        this.faultStatus = faultStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Fault getFault() {
        return fault;
    }

    public void setFaultFk(Fault fault) {
        this.fault = fault;
    }

    public Diagnostics getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(Diagnostics diagnostics) {
        this.diagnostics = diagnostics;
    }

    public FaultStatus getFaultStatus() {
        return faultStatus;
    }

    public void setFaultStatus(FaultStatus faultStatus) {
        this.faultStatus = faultStatus;
    }
}
