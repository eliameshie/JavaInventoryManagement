/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cis434project;

/**
 *
 * @author antho
 */
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class StoreResults {

    public static void main(String[] args) throws Exception {
        Result result = new Result("Test", 100);

        JAXBContext jaxbContext = JAXBContext.newInstance(Result.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // Optional: output nicely formatted
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Write to System.out
        jaxbMarshaller.marshal(result, System.out);

        // Write to file
        File file = new File("result.xml");
        jaxbMarshaller.marshal(result, file);
    }
}

class Result {
    public String name;
    public int score;

    public Result() {} // JAXB needs this

    public Result(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

