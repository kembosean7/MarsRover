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
        double distance = 0;
        try {
              distance = Double.parseDouble(moveCommand[1]);
//            distance = Math.round(distance * 100.0) / 100.0;
        }
        catch (IndexOutOfBoundsException | NumberFormatException e){
            System.out.printf("I've encountered an instruction I don't understand, aborting (instruction %d)%n", i);
            return new double[] {x,y};
        }

        if(moveCommand[-1].equalsIgnoreCase("forward")){
            x += distance * Math.sin(Math.toRadians(orientation));
            y += x += distance * Math.cos(Math.toRadians(orientation));

        } else if(moveCommand[-1].equalsIgnoreCase("backward")) {
            x -= distance * Math.sin(Math.toRadians(orientation));
            y -= x += distance * Math.cos(Math.toRadians(orientation));
        }
        else{
            System.out.printf("I've encountered an instruction I don't understand, aborting (instruction %d)%n", i);
        }

        System.out.printf("Moving %.2f meters %s (instruction %d)%n", distance, moveCommand[moveCommand.length - 1].toLowerCase(), i);
        System.out.printf("I'm at (%.2f, %.2f) facing %.2f degrees%n", x, y, orientation);

        return new double[] {x,y};
    }
}
