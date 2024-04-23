/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cis434project;

/**
 *
 * @author antho
 */
public class Item {
    private String name;
    private int quantity;
    
    public Item(String name,int quantity){
        this.name=name;
        this.quantity=quantity;
        
    }
    public String getName(){
        return name;
    }
    public int getQuanity(){
        return quantity;
    }
    public void setName(String name){
       this.name=name;
    }
    public void setQuanity(int quantity){
        this.quantity=quantity;
    }
    @Override
    public String toString() {
        return name + " - Quantity: " + quantity;
    }
}
