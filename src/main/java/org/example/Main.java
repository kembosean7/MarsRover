package org.example;
import java.io.FileNotFoundException;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        readFile readFile = new readFile();
        List<String> data =readFile.getInstructions("instructions.txt");
        InstructionHandler.instructionMovements(data);

    }
}