package com.mycompany.rubricatelefonica;

import javafx.application.Platform;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class AppTest {

    private App mainInstance;

    

    @AfterAll
    public static void tearDownClass() {
        Platform.exit();
    }

    @BeforeEach
    public void setUp() {
        mainInstance = new App();
    }

    @AfterEach
    public void tearDown() {
        mainInstance = null;
    }

    /**
     * Test of start method, of class Main.
     */
    @Test
    public void testStart() {
        
    }

    /**
     * Test of setRoot method, of class Main.
     */
    @Test
    public void testSetRoot() {
        
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
        System.out.println("Testing main method");
        String[] args = {};
        assertDoesNotThrow(() -> {
            App.main(args);
        }, "The main method should not throw any exception.");
    }
}
