/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cis434project;

/**
 *
 * @author antho
 */
public class ProjectItems implements Item {
    private String name;
    private int quantity;
    private double price;
    
    public ProjectItems(String name, int quantity, double price){
        this.name=name;
        this.quantity=quantity;
        this.price=price;
        
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public int getQuanity(){
        return quantity;
    }
    
    @Override
   public double getPrice(){
        return price;
    }
    @Override
    public void setName(String name){
       this.name=name;
    }

    @Override
    public void setQuanity(int quantity){
        this.quantity=quantity;
    }
    @Override
    public void setPrice(double price){
        this.price=price;
    }
    @Override
    public String toString() {
        return  name + " |Quantity: " + quantity+"Price:"+price;
    }
}
