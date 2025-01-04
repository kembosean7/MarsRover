package org.example;

import java.util.Arrays;
import java.util.List;

public class InstructionHandler {
    public static void instructionMovements(List<String> instructionsData){

        double x = 0, y = 0;
        double orientation = 0;

        System.out.printf("I'm at (%.2f, %.2f) facing %.2f degrees%n", x, y, orientation);

        for(int i = 0; i < instructionsData.size(); i++){
            String instruction = instructionsData.get(i);

            if(instruction.isEmpty()){
                continue;
            }
            if(instruction.toLowerCase().startsWith("move")){
                double[] result= moveCommand(i,orientation,instruction,x,y);
                x = result[0];
                y = result[1];
            } else if (instruction.toLowerCase().startsWith("turn")){
                orientation = turnCommand(i,orientation,instruction,x,y);

            }else{
                System.out.printf("I've encountered an instruction I don't understand, aborting (instruction %d)%n", i+1);
                System.exit(0);

            }
        }


    }
    private static double[] moveCommand(int i, double orientation, String instruction, double x, double y){

        String[] moveCommand = instruction.split("\\s+");
        double distance = 0;
        try {
              distance = Double.parseDouble(moveCommand[1]);
            distance = Math.round(distance * 100.0) / 100.0;
        }
        catch (IndexOutOfBoundsException | NumberFormatException e){
            System.out.printf("I've encountered an instruction I don't understand, aborting (instruction %d)%n", i+1);
            System.exit(0);
            return new double[] {x,y};
        }

        if(moveCommand[moveCommand.length -1].equalsIgnoreCase("forward")){
            x += distance * Math.sin(Math.toRadians(orientation));
            y += distance * Math.cos(Math.toRadians(orientation));

        } else if(moveCommand[moveCommand.length -1].equalsIgnoreCase("backward")) {
            x -= distance * Math.sin(Math.toRadians(orientation));
            y -= distance * Math.cos(Math.toRadians(orientation));
        }
        else{
            System.out.printf("I've encountered an instruction I don't understand, aborting (instruction %d)%n", i+1);
            System.exit(0);
        }

        if(Math.abs(x) < 0.01){
            x = 0.00;
        }
        if(Math.abs(y) < 0.01){
            y = 0.00;
        }


        System.out.printf("Moving %.2f meters %s (instruction %d)%n", distance, moveCommand[moveCommand.length - 1].toLowerCase(), i+1);
        System.out.printf("I'm at (%.2f, %.2f) facing %.2f degrees%n", x, y, orientation);

        return new double[] {x,y};
    }
    private static double turnCommand(int i, double orientation, String instruction, double x, double y){

        String[] turnCommand = instruction.split("\\s+");
        double angle = 0;
        try{
            angle = Double.parseDouble(turnCommand[1]);
        }
        catch (IndexOutOfBoundsException | NumberFormatException e){
            System.out.printf("I've encountered an instruction I don't understand, aborting (instruction %d)%n", i+1);
            System.exit(0);
        }

        String turnDirection = turnCommand[turnCommand.length - 1];
        if(turnDirection.equalsIgnoreCase("clockwise")){
            orientation = (orientation + angle) % 360;

        } else if (turnDirection.equalsIgnoreCase("counterclockwise")) {
            orientation = (orientation - angle) % 360;

        }else {
            System.out.printf("I've encountered an instruction I don't understand, aborting (instruction %d)%n", i+1);
            System.exit(0);
        }

        System.out.printf("Turning %.2f degrees %s (instruction %d)%n", angle, turnDirection, i+1);
        System.out.printf("I'm at (%.2f, %.2f) facing %.2f degrees%n", x, y, orientation);
        return orientation;
    }
}