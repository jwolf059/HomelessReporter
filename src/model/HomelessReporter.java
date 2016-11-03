/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author JeremyWolf
 */
public class HomelessReporter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    csvImporter importer = new csvImporter();
    ArrayList<String> temp;
    ArrayList<ClientRecord> clients;
    try {
        temp = importer.agencyListBuilder(new File("/Users/JeremyWolf/Downloads/Agency_2016.csv"));
        clients = importer.clientListBuilder(new File("/Users/JeremyWolf/Downloads/Annual_Report.csv"));
         //for (String name: temp) {
               // System.out.println(name);
        //}
         System.out.println("Number of Clients" + clients.size());
    }
    catch (FileNotFoundException e) {
          
        }
    
   
    
    
    }
    

    
}
