package application;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Item {
	
	// price and image name
	private String food;
	private float price;
	
	// constructor
	public Item(String food, float price) {
		this.food = food;
		this.price = price;
	}
	
	public String getFood() {
		return food;
	}
	
	public float getPrice() {
		return price;
	}
	
}
