package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {

    private final List<ProjectItems> items = new ArrayList<>();
    private final ListView<ProjectItems> listView = new ListView<>();
    private final TextField totalField = new TextField();

    @Override
    public void start(Stage stage) throws IOException {
    	
        TextField nameField = new TextField();
        nameField.setPromptText("Enter the item:");
        
        TextField quantityField = new TextField();
        quantityField.setPromptText("Enter the number of items:");
        
        TextField priceField = new TextField();
        priceField.setPromptText("Enter the price");
        
        Button addBtn = new Button("Add");
        addBtn.setOnAction(e -> {
            try {
                String name = nameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());
                addItem(name, quantity, price);
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input. Please ensure quantity and price are numeric.");
            }
        });
        Button delBtn = new Button("Delete");
        
        // spicing it up
        Button calcTotalBtn = new Button("Calculate subtotal");
        calcTotalBtn.setOnAction(e -> calculateTotal());
       
        delBtn.setOnAction(e -> delItem());
        
        totalField.setEditable(false);
     
        VBox root = new VBox(10, nameField, quantityField, priceField, addBtn, delBtn, calcTotalBtn, listView);
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Inventory Management System");
        stage.show();
    }

    private void addItem(String name, int quantity, double price) {
        ProjectItems item = new ProjectItems(name, quantity, price);
        items.add(item);
        updateListView();
    }

    private void delItem() {
        ProjectItems item = listView.getSelectionModel().getSelectedItem();
        if (item != null) {
            items.remove(item);
            updateListView();
        }
    }

    private void updateListView() {
        listView.getItems().clear();
        listView.getItems().addAll(items);
    }
    
    private void calculateTotal() {
    	double total = 0.0;
        for (ProjectItems item : items) {
            if (listView.getSelectionModel().getSelectedItem() != null) {
                double price = item.getPrice();
                int quantity = item.getQuantity();
                System.out.println("Price: " + price + ", Quantity: " + quantity);
                // this is a bug right now
                total += price * quantity;
            }
        }
        System.out.println("Total: " + total);
        totalField.setText("Total value of selected items: $" + total);
        
        // Check if totalField is already added to the VBox
        if (totalField.getParent() == null) {
            ((VBox) listView.getParent()).getChildren().add(totalField);
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
