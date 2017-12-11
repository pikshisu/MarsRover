package com.company;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    final int N = 0;
    final int E = 1;
    final int S = 2;
    final int W = 3;

    // TestCase1: Data provided in email
    @Test
    public void testCase1() throws Exception {
        // Change System.out
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Instantiate plateau and rover objects
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(plateau);

        // Execute given instructions
        rover.setPosition(1, 2, N);
        rover.execute("LMLMLMLMM");

        rover.setPosition(3, 3, E);
        rover.execute("MMRMMRMRRM");

        // Assert that the console matches the expected output
        String expected = "1 3 N\r\n5 1 E\r\n";
        assertEquals(expected, output.toString());
    }

    // TestCase2: Invalid plateau size
    @Test
    public  void testCase2() throws Exception {
        // Change System.out
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Instantiate plateau object with invalid parameters
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Plateau plateau = new Plateau(-2, 5);
        });

        assertEquals("Invalid plateau size.", exception.getMessage());
    }

    // TestCase3: Invalid starting position
    @Test
    public  void testCase3() throws Exception {
        // Change System.out
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Instantiate plateau and rover objects
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(plateau);

        // Set invalid rover position
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            rover.setPosition(-1, 2, N);
        });

        assertEquals("Invalid starting position: -1 2 N", exception.getMessage());
    }

    // TestCase4: Invalid instruction
    @Test
    public  void testCase4() throws Exception {
        // Change System.out
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Instantiate plateau and rover objects
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(plateau);

        // Execute invalid instruction
        rover.setPosition(1, 2, N);
        rover.execute("LMLMLML6MM");

        assertEquals("Invalid instruction: 6\r\n", output.toString());
    }

    // TestCase5: Bounds Checking
    @Test
    public  void testCase5() throws Exception {
        // Change System.out
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Instantiate plateau and rover objects
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(plateau);

        // Move out of plateau
        rover.setPosition(1, 2, N);
        rover.execute("RMMMMMLML");

        assertEquals("Exploration failed, rover has gone out of bounds.\r\n", output.toString());
    }
}