/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * ClientRecord class provides storage for a clients unique Identification number
 * as well as an ArrayList of all programs that the client was enrolled in
 * during the reporting period.
 * @author JeremyWolf
 */
public class ClientRecord {
    
    // String value for Clients alphanumeric Identification number.
    private static String myUniqueID;
    private static ArrayList<Program> myPrograms;
    private static HashSet<String> myVistedAgencies;
    
    /*
    * Constructor for a new ClientRecord.
    * @params id the clients Unique Identification number as a String.
    */
    public ClientRecord(String theID) {
        myUniqueID = theID;
        myPrograms = new ArrayList<>();
        myVistedAgencies = new HashSet<>();
    }
    
    /*
    * Add program to the visted Agencies Set 
    */
    public void addAgency(String theAgency) {
        myVistedAgencies.add(theAgency);
    }
    
    public void addProgram(Program thePrg) {
        myPrograms.add(thePrg);
    }
    
    /*
    * Getter method for the Clients Unique Identification number.
    * @return Clients Unique Identification number as a string
    */
    public String getID() {
        return myUniqueID;
    }
    
    /*
    * Getter method for the Clients Program List. Provides a copy of all 
    * programs the clients was enrolled.
    * @return an ArrayList of Client enrolled progams.
    */
    public ArrayList<Program> getEnrollments() { 
        return myPrograms;
    }
    
      /*
    * Getter method for the Clients Program List. Provides a copy of all 
    * programs the clients was enrolled.
    * @return an ArrayList of Client enrolled progams.
    */
    public HashSet<String> getAgencies() {
        return myVistedAgencies;
    }
}

