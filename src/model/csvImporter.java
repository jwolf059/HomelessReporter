/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JeremyWolf
 */
public class csvImporter {
    private ArrayList<String> agencyList;
    
    public csvImporter() {
        
    }
    
    
    public ArrayList<String> agencyListBuilder(File theFile) throws FileNotFoundException {
        agencyList = new ArrayList<>();
        Scanner agencyScan = new Scanner(theFile);
        
        agencyScan.useDelimiter(",");
        
        while (agencyScan.hasNext()) {
            agencyList.add(agencyScan.next());
        }
        
        agencyScan.close();
        return agencyList;
    }
    
    public ArrayList<ClientRecord> clientListBuilder(File theFile) throws FileNotFoundException {
        ArrayList<ClientRecord> clientRecordList = new ArrayList<>();
        Scanner scan = new Scanner(theFile);
     
      
        
        while (scan.hasNextLine()) {
            Scanner lineScanner = new Scanner(scan.nextLine());
            ClientRecord client = null;
            int clientAtIndex = -1;
            lineScanner.useDelimiter(",");
            
            // Gets the Client ID (this is Unique to each client)
            String clientID = lineScanner.next();
            String exitHousingStatus = lineScanner.next();
            String entryDate = lineScanner.next();
            String exitDate = lineScanner.next();
            String headOfhouse = lineScanner.next();
            String programType = lineScanner.next();
            String entryStatus = lineScanner.next();
            String exitDestination = lineScanner.next();
            String agencyName = lineScanner.next();
            String dateCreated = lineScanner.next();
            
            
            System.out.println("ID " + clientID);
            System.out.println("Exit Status " + exitHousingStatus);
            System.out.println("Entry Date " + entryDate);
            System.out.println("Exit Date " + exitDate);
            System.out.println("HoH " + headOfhouse);
            System.out.println("Prg type " + programType);
            System.out.println("Entry Stat " + entryStatus);
            System.out.println("Exit Dest. " + exitDestination);
            System.out.println("Agency Name " + agencyName);
            System.out.println("Date Created " + dateCreated);
            System.out.println("New Record");
            
            //Check to see if the client exists already
            for (int i = 0; i < clientRecordList.size(); i++) {
                ClientRecord check = clientRecordList.get(0);
                
                // If client exists break the loop, set the index and flag.
                if (check.getID() == clientID) {
                    clientAtIndex = i;
                    break;
                }
            }
            
            // If client does not exist create a new one, or get the existing client.
            if (clientAtIndex < 0) {
                client = new ClientRecord(clientID);
                System.out.println("New clientrecord created");
            } else {
                client = clientRecordList.get(clientAtIndex);
                clientAtIndex = -1;
                System.out.println("clientrecord Found");

            }
            
            //LOOK AT Possibly concatenating the Agency name and Program type.
            client.addAgency(agencyName);
            
            // Creates local date objects from date strings
            LocalDate pgrEntryDate = createLocalDate(entryDate);
            System.out.println("Entry Date Created");

            LocalDate pgrExitDate = createLocalDate(exitDate);
            System.out.println("Exit Date Created");
            LocalDate recordCreatedDate = createLocalDate(dateCreated);
            System.out.println("Created Date Created");
            
            boolean isHofH = isHeadofHousehold(headOfhouse);
            
            
            Program prg = new Program(agencyName, recordCreatedDate, 
                    pgrEntryDate, pgrExitDate, programType, exitDestination, 
                    isHofH);
            
            client.addProgram(prg);
            pgrExitDate = null;
                
        }
        
        scan.close();
        return clientRecordList;
    }
    
    public LocalDate createLocalDate(String theDate) {
        LocalDate date = null;
        System.out.println(theDate);
        if (theDate.length() != 2) {
            Scanner dateScanner = new Scanner(theDate);
            dateScanner.useDelimiter("-");
            int year = dateScanner.nextInt();
            int month = dateScanner.nextInt();
            int day = dateScanner.nextInt();
            date = LocalDate.of(year, month, day);
        }
        
        return date;
    }
    
    public boolean isHeadofHousehold(String theString) {
        if (theString.equals("Yes")) {
            return true;
        } else {
            return false;
        }
        
    }
    
}
