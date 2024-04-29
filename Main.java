package application;
	
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;



public class Main extends Application {
	
	private Stage window;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		List<Item> itemList = parseXML("D:\\Users\\strid\\eclipse-workspace\\SideQuest\\src\\products.xml");
		Parent root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Shopping Cart");
		primaryStage.setScene(scene);
		primaryStage.show();
		if (itemList != null) {
			ObservableList<Item> observableItemList = FXCollections.observableArrayList(itemList);
			ListView<Item> listView = new ListView<>(observableItemList);
	
		}
	}
	
	public static List<Item> parseXML(String filename) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filename));
            document.getDocumentElement().normalize();
            NodeList productList = document.getElementsByTagName("item");
            
            for (int i = 0; i < productList.getLength(); i++) {
                Node product = productList.item(i);
                if (product.getNodeType() == Node.ELEMENT_NODE) {
                    Element productElement = (Element) product;
                    String food = productElement.getElementsByTagName("food").item(0).getTextContent();
                    String price = productElement.getElementsByTagName("price").item(0).getTextContent();
                    System.out.println("Product name: " + food);
                    System.out.println("Product price: " + price);
                }
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
