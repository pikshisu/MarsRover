package com.company;

import com.sun.corba.se.impl.io.TypeMismatchException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int N = 0;
        final int E = 1;
        final int S = 2;
        final int W = 3;

        // Enter upper right coordinates below:
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(plateau);

        // Enter rover parameters below:
        rover.setPosition(1, 2, N);
        rover.execute("LMLMLMLMM");

        rover.setPosition(3, 3, E);
        rover.execute("MMRMMRMRRM");
    }
}
