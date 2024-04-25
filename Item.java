/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.cis434project;

/**
 *
 * @author antho
 */
public interface Item {
    String getName();
    int getQuanity();
    double getPrice();
    void setName(String name);
    void setQuanity(int quantity);
    void setPrice(double price);
   
    @Override
    String toString();
    
    
}
