package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        readFile readFile = new readFile();
        List<String> data =readFile.getInstructions("instructions.txt");
//        InstructionHandler.instructionMovements(data);
        System.out.println(data);
    }
}