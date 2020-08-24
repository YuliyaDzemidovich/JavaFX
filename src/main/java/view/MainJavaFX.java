package view;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Order;

import java.util.List;

public class MainJavaFX extends Application {
    static final Controller controller = new Controller();
    TableView ordersTableView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Orders");

        ordersTableView = new TableView();
        ordersTableView.prefWidthProperty().bind(stage.widthProperty());
        addColumnsToTable();
        fillOrdersTable();
        ordersTableView.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                ordersTableView.getItems().clear();
                fillOrdersTable();
                }
            }
        });

        Button buttonAddOrder = new Button();
        buttonAddOrder.setText("Add order");
        buttonAddOrder.setPrefSize(110, 40);
        buttonAddOrder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Add order button click!");
            }
        });

        Button buttonEditOrder = new Button();
        buttonEditOrder.setText("Edit order");
        buttonEditOrder.setPrefSize(110, 40);
        buttonEditOrder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Edit order button click!");
            }
        });

        Button buttonDeleteOrder = new Button();
        buttonDeleteOrder.setText("Delete order");
        buttonDeleteOrder.setPrefSize(110, 40);
        buttonDeleteOrder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Delete order button click!");
            }
        });

        Button buttonManageEmployees = new Button();
        buttonManageEmployees.setText("Manage employees");
        buttonManageEmployees.setPrefSize(150, 40);
        buttonManageEmployees.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Manage employees button click!");
            }
        });

        VBox root = new VBox();
        root.setSpacing(50);
        root.getChildren().add(ordersTableView);

        HBox buttonsBox = new HBox();
        buttonsBox.setSpacing(20);
        buttonsBox.setAlignment(Pos.BASELINE_CENTER);
        buttonsBox.getChildren().addAll(buttonAddOrder, buttonEditOrder, buttonDeleteOrder, buttonManageEmployees);
        root.getChildren().add(buttonsBox);

        Scene scene = new Scene(root, 600, 550);
        stage.setScene(scene);
        stage.show();
    }

    public void addColumnsToTable() {
        TableColumn clientNameCol = new TableColumn("Client");
        clientNameCol.setCellValueFactory(new PropertyValueFactory<>("client"));
        TableColumn vehicleCol = new TableColumn("Vehicle");
        vehicleCol.setCellValueFactory(new PropertyValueFactory<>("vehicle"));
        TableColumn createdDateCol = new TableColumn("Created on");
        createdDateCol.setCellValueFactory(new PropertyValueFactory<>("createdDate"));
        TableColumn finishedDateCol = new TableColumn("Finished on");
        finishedDateCol.setCellValueFactory(new PropertyValueFactory<>("finishedDate"));
        TableColumn totalSumCol = new TableColumn("Total");
        totalSumCol.setCellValueFactory(new PropertyValueFactory<>("total"));
        TableColumn statusCol = new TableColumn("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        ordersTableView.getColumns().addAll(clientNameCol, vehicleCol, createdDateCol,
                finishedDateCol, totalSumCol, statusCol);
    }

    public void fillOrdersTable() {
        ObservableList<OrderView> list = FXCollections.observableArrayList();
        List<Order> orders = controller.getAllOrders();

        for (Order order : orders) {
            list.add(new OrderView(order));
        }

        ordersTableView.setItems(list);
    }
}
