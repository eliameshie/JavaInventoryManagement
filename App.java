package com.mycompany.cis434project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * JavaFX App
 */
public class App extends Application {

    private final List<ProjectItems> items = new ArrayList<>();
    private final ListView<ProjectItems> listView = new ListView<>();

    @Override
    public void start(Stage stage) throws IOException {
        TextField namefield = new TextField();
        namefield.setPromptText("Enter the item:");
        TextField quanityfield = new TextField();
        TextField pricefield = new TextField();
        quanityfield.setPromptText("Enter the number of items:");
        Button addBtn = new Button("add");
        addBtn.setOnAction(e -> {
                String name = namefield.getText();
                int quantity = Integer.parseInt(quanityfield.getText());
                double price = Double.parseDouble(pricefield.getText());
                addItem(name, quantity, price);
        });
        Button delBtn = new Button("delete");
        delBtn.setOnAction(e -> delItem());
        VBox root = new VBox(10, namefield, quanityfield, addBtn, delBtn, listView);
        stage.setScene(new Scene(root, 400, 400));
        stage.setTitle("Inventory Management System");
        stage.show();
    }
    private void addItem(String name, int quantity,double price){
        ProjectItems item1 = new ProjectItems(name,quantity,price);
        items.add(item1);
        updateListView();
    }
    private void delItem(){
        ProjectItems item2 = listView.getSelectionModel().getSelectedItem();
        listView.getSelectionModel().getSelectedItem();
          if (item2 != null) {
            items.remove(item2);
            updateListView();
        }
    }
        private void updateListView() {
        listView.getItems().clear();
        listView.getItems().addAll(items);
    }
    
    

    public static void main(String[] args) {
        launch();
    }

}