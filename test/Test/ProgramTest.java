package Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import model.Program;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author JeremyWolf
 */
public class ProgramTest {
    public static LocalDate entry;
    public static LocalDate exit;
    public static LocalDate afterCreation;
    public static LocalDate beforeCreation;
    public static LocalDate afterExit;
    public static LocalDate dateCreated;
    public static LocalDate oneYearDateCreated;
    public static LocalDate oneYearBeforeCreation;
    public static LocalDate oneYearAfterCreation;
    public static LocalDate oneYearbeforeExit;
    public static LocalDate oneYearAfterExit;
    public static Program testProgram;

    
    public ProgramTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        entry = LocalDate.of(2016, 10, 12);
        exit = LocalDate.of(2016, 11, 12);
        afterCreation = LocalDate.of(2016, 11, 12);
        beforeCreation = LocalDate.of(2016, 4, 12);
        afterExit = LocalDate.of(2016, 8, 06);
        dateCreated = LocalDate.of(2016, 5, 17);
        
        oneYearDateCreated = LocalDate.of(2015, 2, 17);
        oneYearBeforeCreation = LocalDate.of(2014, 1, 22);
        oneYearAfterCreation = LocalDate.of(2016, 5, 28);
     
        oneYearbeforeExit = LocalDate.of(2015, 5, 21);
        oneYearAfterExit = LocalDate.of(2017, 11, 19);
        
        
       testProgram = new Program("Test Program", dateCreated, entry, exit,
                                "Rental Assistance", "Rental", true);

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testCaculateDaysActiveEntryBeforeExit() {
        Long test = testProgram.caculateDaysActive(entry, exit);
        assertTrue(test == 31);
    }
    
    @Test
    public void testCaculateDaysActiveEntryAfterExit() {
        Long test = testProgram.caculateDaysActive(entry, afterExit);
        assertTrue(test == -67);
    }
    
    @Test
    public void testCaculateDaysActiveEntryBeforeExitOverOneYear() {
        Long test = testProgram.caculateDaysActive(oneYearbeforeExit, exit);
        assertTrue(test == 541);
    }
    
    @Test
    public void testCaculateDaysActiveEntryAfterExitOverOneYear() {
        Long test = testProgram.caculateDaysActive(oneYearAfterExit, exit);
        assertTrue(test == -372);
    }
    
    @Test
    public void testCaculateDataTImelinessEntryBeforeCreation(){
        Long test = testProgram.caculateDaysActive(dateCreated, beforeCreation);
        assertTrue(test == -35);
    }
    
    @Test
    public void testCaculateDataTimelinessEntryAfterCreation() {
        Long test = testProgram.caculateDaysActive(dateCreated, afterCreation);
        assertTrue(test == 179);
    }
    
        @Test
    public void testCaculateDataTImelinessEntryBeforeCreationOverOneYear(){
        Long test = testProgram.caculateDaysActive(oneYearDateCreated, oneYearBeforeCreation);
        assertTrue(test == -391);
    }
    
    @Test
    public void testCaculateDataTimelinessEntryAfterCreationOverOneYear() {
        Long test = testProgram.caculateDaysActive(oneYearDateCreated, oneYearAfterCreation);
        assertTrue(test == 466);
    }
    
}
