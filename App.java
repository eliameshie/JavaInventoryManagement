package application;

import java.io.File;
import java.io.FileWriter;
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
        Button xmlBtn = new Button("Calculate total");
       
        delBtn.setOnAction(e -> delItem());
        xmlBtn.setOnAction(e -> generateXML());
        
        totalField.setEditable(false);
     
        VBox root = new VBox(10, nameField, quantityField, priceField, addBtn, delBtn, xmlBtn, listView);
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
    
    private void generateXML() {
    	try {
    		   // Calculate total price and count total number of items
            double totalPrice = 0.0;
            int totalItems = items.size();
            for (ProjectItems item : items) {
                totalPrice += item.getPrice() * item.getQuantity();
            }

            // Construct XML content
            StringBuilder xmlContent = new StringBuilder();
            xmlContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            xmlContent.append("<result>\n");
            xmlContent.append("\t<totalItems>").append(totalItems).append("</totalItems>\n");
            xmlContent.append("\t<totalPrice>").append(totalPrice).append("</totalPrice>\n");
            xmlContent.append("</result>");

            // Write XML content to file
            File xmlFile = new File("D:\\Users\\strid\\eclipse-workspace\\PLEAAASE\\result.xml");
            FileWriter writer = new FileWriter(xmlFile);
            writer.write(xmlContent.toString());
            writer.close();

            System.out.println("XML generated and saved to " + xmlFile.getAbsolutePath());
            
            // Display total price on the VBox
            totalField.setText("Total price of all items: $" + totalPrice);
            if (totalField.getParent() == null) {
                ((VBox) listView.getParent()).getChildren().add(totalField);
            }
        } catch (IOException ex) {
            System.err.println("Error generating XML: " + ex.getMessage());
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
