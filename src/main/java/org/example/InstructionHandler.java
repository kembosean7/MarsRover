package org.example;

import java.util.List;

public class InstructionHandler {
    public static void instructionMovements(List<String> instructionsData){

        double x = 0, y = 0;
        double orientation = 0;

        System.out.printf("I'm at (%.2f, %.2f) facing %.2f degrees%n", x, y, orientation);


    }
    private static double[] moveCommand(int i, double orientation, String instruction, double x, double y){

        String[] moveCommand = instruction.split(" ");
        try {
            double distance = Double.parseDouble(moveCommand[1]);
            distance = Math.round(distance * 100.0) / 100.0;
        }
        catch (IndexOutOfBoundsException | NumberFormatException e){
            System.out.printf("I've encountered an instruction I don't understand, aborting instruction %d", i);
            return new double[] {x,y};
        }


    }
}
