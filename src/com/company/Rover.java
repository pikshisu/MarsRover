package com.company;

public class Rover {
    private static final int N = 0;
    private static final int E = 1;
    private static final int S = 2;
    private static final int W = 3;

    // Error messages
    private static final String BAD_START = "Invalid starting position: ";
    private static final String BAD_INSTRUCTION = "Invalid instruction: ";
    private static final String OUT_OF_BOUNDS = "Exploration failed, rover has gone out of bounds.";

    // Default rover position
    private int x = 0;
    private int y = 0;
    private int orientation = N;

    private Plateau plateau;

    /*
        Rover Setup
     */

    public Rover(Plateau plateau) {
        this.plateau = plateau;
    }

    public void setPosition(int x, int y, int orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        if(!plateau.isValidPositon(x, y)) {
            throw new IllegalArgumentException(BAD_START + getPosition());
        }
    }

    /*
        Current Position
     */

    private char getCharOrientation(int num) {
        switch (num) {
            case 0:
                return 'N';
            case 1:
                return 'E';
            case 2:
                return 'S';
            case 3:
                return 'W';
            default:
                return 0;
        }
    }

    private String getPosition() {
        return x + " " + y + " " + getCharOrientation(orientation);
    }

    /*
        Rover Instructions
     */

    private void turnLeft() {
        orientation = (orientation + 3) % 4;
    }

    private void turnRight() {
        orientation = (orientation + 1) % 4;
    }

    private void move() {
        switch (orientation) {
            case 0:
                this.y++; // North
                break;
            case 1:
                this.x++; // East
                break;
            case 2:
                this.y--; // South
                break;
            case 3:
                this.x--; // West
                break;
        }
    }

    /*
        Execution
     */

    private boolean doInstruction(char instruction) {
        switch (instruction) {
            case 'M':
                move();
                break;
            case 'L':
                turnLeft();
                break;
            case 'R':
                turnRight();
                break;
            default:
                return false; // Invalid instruction
        }
        return true;
    }

    public void execute(String instructions) {
        // If empty string, print current position
        if(instructions.isEmpty()) {
            System.out.println(getPosition());
        }

        for(int i = 0; i < instructions.length(); i++) {
            if(!doInstruction(instructions.charAt(i))) {
                // If invalid instruction, then break
                System.out.println(BAD_INSTRUCTION + instructions.charAt(i));
                break;
            } else {
                // If rover is out of bounds, then break
                if(!plateau.isValidPositon(this.x, this.y)) {
                    System.out.println(OUT_OF_BOUNDS);
                    break;
                }

                // If end of string, print current position
                if(i == instructions.length() - 1) {
                    System.out.println(getPosition());
                }
            }
        }
    }
}
