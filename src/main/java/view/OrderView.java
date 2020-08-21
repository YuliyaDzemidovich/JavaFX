package view;

import model.CompanyClient;
import model.IndividualClient;
import model.Order;

/**
 * This class helps display Order details in main JavaFX window.
 * It consists only of String fields.
 * With given Order object the constructor of this class returns
 * OrderView object ready to display in TableView.
 */
public class OrderView {
    private String client;
    private String vehicle;
    private String createdDate;
    private String finishedDate;
    private String total;
    private String status;

    public OrderView(Order order) {
        if (order.getClient() instanceof IndividualClient) {
            IndividualClient individualClient = (IndividualClient)order.getClient();
            this.client = individualClient.getSurname() + " " +
                    individualClient.getName() + " " +
                    individualClient.getPatronage();
        } else if (order.getClient() instanceof CompanyClient) {
            CompanyClient companyClient = (CompanyClient)order.getClient();
            this.client = companyClient.getName();
        } else {
            System.out.println("Error: cannot recognize Client type with id = " + order.getClient().getId());
        }
        this.vehicle = order.getVehicle().getModel().getName();
        this.createdDate = order.getCreatedDate().toString();
        this.finishedDate = order.getActualFinishDate().toString();
        this.total = String.valueOf(order.getTotalSum());
        this.status = order.getStatus().toString();
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(String finishedDate) {
        this.finishedDate = finishedDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
