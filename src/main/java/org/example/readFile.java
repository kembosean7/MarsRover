package org.example;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class readFile {
    public List<String> getInstructions(String filename) throws FileNotFoundException{

        List<String> list = new ArrayList<>();
        try{
            FileReader myObj = new FileReader(filename);
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String line = myReader.nextLine();
                list.add(line);

            }
            myReader.close();
        }catch (FileNotFoundException e){
            throw new FileNotFoundException("File not found");
        }
        return list;
    }
}
