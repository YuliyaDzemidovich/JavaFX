package view;

import controller.Controller;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
//        primaryStage.setTitle("database app");
//        Button btn = new Button();
//        btn.setText("JavaFX check");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("Hello World!");
//            }
//        });
//
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        primaryStage.setScene(new Scene (root, 300, 250));
//        primaryStage.show();

        ordersTableView = new TableView();
        fillOrdersTable();
        Scene scene = new Scene(ordersTableView);
        stage.setScene(scene);
        stage.show();
    }

    public void fillOrdersTable() {
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

        // TODO: clear tableview first?
        ordersTableView.getColumns().addAll(clientNameCol, vehicleCol, createdDateCol,
                finishedDateCol, totalSumCol, statusCol);

        ObservableList<OrderView> list = FXCollections.observableArrayList();
        List<Order> orders = controller.getAllOrders();

        for (Order order : orders) {
            list.add(new OrderView(order));
        }

        ordersTableView.setItems(list);
    }
}
