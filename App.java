package com.mycompany.cis434project;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.xml.bind.JAXBException;

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
        quanityfield.setPromptText("Enter the number of items:");
        TextField pricefield = new TextField();
        pricefield.setPromptText("Enter the price");
        Button addBtn = new Button("add");
        addBtn.setOnAction(e -> {
            try {
                String name = namefield.getText();
                int quantity = Integer.parseInt(quanityfield.getText());
                double price = Double.parseDouble(pricefield.getText());
                addItem(name, quantity,price);
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input. Please ensure quantity and price are numeric.");
            }
        });
        Button delBtn = new Button("delete");
        Button xmlBtn = new Button("print");
        delBtn.setOnAction(e -> delItem());
        xmlBtn.setOnAction(e -> generateXML());
        VBox root = new VBox(10, namefield, quanityfield,pricefield, addBtn, delBtn, xmlBtn, listView);
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
    private void generateXML() {
    try {
        Result result = processData();
        JAXBContext jaxbContext = JAXBContext.newInstance(Result.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter sw = new StringWriter();
        jaxbMarshaller.marshal(result, sw);
        jaxbMarshaller.marshal(result, new File("result.xml"));

        // Print XML to console
        System.out.println(sw.toString());
        System.out.println("XML generated and saved to " + new File("result.xml").getAbsolutePath());
    } catch (JAXBException ex) {
        System.err.println("Error generating XML: " + ex.getMessage());
    }
}
    
 private static Result processData() {
        // Example processing logic
        return new Result("Example Test", 90);
    }
   public static void main(String[] args)  {
        launch(args);
        
    }

   
}

   

    

