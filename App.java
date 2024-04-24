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

    private List<Item> items = new ArrayList<>();
    private ListView<Item> listView = new ListView<>();

    @Override
    public void start(Stage stage) throws IOException {
        TextField namefield = new TextField();
        namefield.setPromptText("Enter the item:");
        TextField quanityfield = new TextField();
        quanityfield.setPromptText("Enter the number of items:");
        Button addBtn = new Button("add");
        addBtn.setOnAction(e -> addItem(namefield.getText(), Integer.parseInt(quanityfield.getText())));
        Button delBtn = new Button("delete");
        delBtn.setOnAction(e -> delItem());
        VBox root = new VBox(10, namefield, quanityfield, addBtn, delBtn, listView);
        stage.setScene(new Scene(root, 400, 400));
        stage.setTitle("Inventory Management System");
        stage.show();
    }
    private void addItem(String name, int quantity){
        Item item1 = new Item(name,quantity);
        items.add(item1);
        updateListView();
    }
    private void delItem(){
        Item item2 = listView.getSelectionModel().getSelectedItem();
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