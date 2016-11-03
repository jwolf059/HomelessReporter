/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Calendar;


/**
 *
 * @author JeremyWolf
 */
public class Program {
    private static String myProgramName;
    private static LocalDate myDateCreated;
    private static LocalDate myEntryDate;
    private static LocalDate myExitDate;
    private static String myProgramType;
    private static String myExitDestination;
    private static boolean myIsActive;
    private static boolean myIsHeadofHousehold;
    private final long myDaysinProgram;
    private final long myDataTimeliness;
    
    
    
    /*
    * Constructor for a new Program.
    *@param theProgramName a string that contains the name of the program.
    *@param theDateCreated a string that contains the date the record was 
    *created.
    *@param theEntryDate a string that contains the date the client entered 
    *the program.
    *@param theExitDate a string that contains the date the client exited the 
    * program (can be an empty string if client is still actively enrolled).
    *@param theProgramType a string that contains the type of program.
    *@param theExitDestination a string describing the exit destination.
    *@param  theIsHeadofHousehold a Boolean for if the client is the head of 
    *household.
    */

    public Program(String theProgramName, LocalDate theDateCreated, LocalDate theEntryDate,
                   LocalDate theExitDate, String theProgramType, String theExitDestination,
                   boolean theIsHeadofHousehold) {
        myProgramName = theProgramName;
        myDateCreated = theDateCreated;
        myEntryDate = theEntryDate;
        myExitDate = theExitDate;
        
        if (myExitDate == null) {
            myIsActive = true;
            myDaysinProgram = 0; // not zero need to add an input for date if still active
        } else {
            myIsActive = false;
            myDaysinProgram = caculateDaysActive(myEntryDate, myExitDate);
        }
        
        myDataTimeliness = caculateDataTimeliness(myDateCreated, myEntryDate);
        myProgramType = theProgramType;
        myExitDestination = theExitDestination;
        myIsHeadofHousehold =  theIsHeadofHousehold;

    }
    
   /*
    * Caculates the number of days between the Clients progarm record creation
    * and progarm Entry dates.
    * @param theEntryDate a Calendar object for the Clients program Entry Date.
    * @param theDateCreated a Calendar object for the Clients program record 
    * creation Date.
    * @return a long containing the number of days between Exit and Enrollment Date.
    */
    public long caculateDataTimeliness(LocalDate theDateCreated, LocalDate theEntryDate) {

        
        return DAYS.between(theDateCreated, theEntryDate);
    }
    
   /*
    * Caculates the number of days between the Clients Exit and Entry dates.
    * @param theEntryDate a Calendar object for the Clients program Entry Date.
    * @param theExitDate a Calendar object for the Clients program Exit Date.
    * @return a long containing the number of days between Exit and Entry Date.
    */
    public long caculateDaysActive(LocalDate theEntryDate, LocalDate theExitDate) {
              
        return DAYS.between(theEntryDate, theExitDate);
    }
    
   /*
    * Getter method for the Program Name.
    * @return a String representation of the Program Name.
    */
    public String getProgramName() {
        return myProgramName;
    }
    
   /*
    * Getter method for the Date Created.
    * @return a Calendar representation of the Date Created.
    */
    public LocalDate getDateCreated() {
        return myDateCreated;
    }
    
   /*
    * Getter method for the Entry Date.
    * @return a Calendar representation of the Entry Date.
    */
    public LocalDate getEntryDate() {
        return myEntryDate;
    }
   /*
    * Getter method for the Exit Date.
    * @return a Calendar representation of the Exit Date.
    */
    public LocalDate getExitDate() {
        return myExitDate;
    }
    
   /*
    * Getter method for the Program Type.
    * @return a String representation of the Program Type.
    */
    public String getProgramType() {
        return myProgramType;
    }

   /*
    * Getter method for the Exit Destination.
    * @return a String representation of the Exit Destination.
    */
    public String getExitDestination() {
        return myExitDestination;
    }
    
   /*
    * Getter method for the is Head of Household Boolean.
    * @return a Boolean true if Client is Head of Household.
    */
    public Boolean isHeadOfHousehold() {
        return myIsHeadofHousehold;
    }
    
   /* Getter method for the is Active.
    * @return a Boolean true if Client is Active in the program.
    */
    public Boolean isActive() {
        return myIsActive;
    }
    
   /* Getter method for Data Timliness.
    * @return a long for the number of days between program record creation and 
    * program entry.
    */
    public long getDataTimliness() {
        return myDataTimeliness;
    }
    
   /* Getter method for Days active in program.
    * @return a long for the number of days between program exit and 
    * program entry.
    */
    public long getDaysActive() {
        return myDaysinProgram;
        
    }
}
