import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.example.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class testMarsRover {

    @Test
    public void testReadFile() throws FileNotFoundException {

        readFile readFile = new readFile();
        List<String> output = readFile.getInstructions("instructions.txt");
        List<String> expectedOutput = Arrays.asList(
                "Move 10 meters forward",
                "Turn 90 degrees clockwise",
                "Move 5 meters forward",
                "Turn 90 degrees counterclockwise",
                "Move 10 meters forward");

        assertEquals(expectedOutput,output);

    }

    @Test
    public void testReadInvalidFile(){

        readFile readFile = new readFile();
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () -> { readFile.getInstructions("invalidffile.txt");});
        assertEquals("File not found", exception.getMessage());

    }
    @Test
    public void testInstructionMovements(){

        List<String> data = Arrays.asList(
                "Move 10 meters forward",
                "Turn 90 degrees clockwise",
                "Move 5 meters forward",
                "Turn 90 degrees counterclockwise",
                "Move 10 meters forward   "
        );
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        InstructionHandler.instructionMovements(data);

        String expectedOutput = "I'm at (0.00, 0.00) facing 0.00 degrees\r\n" +
                "Moving 10.00 meters forward (instruction 1)\r\n" +
                "I'm at (0.00, 10.00) facing 0.00 degrees\r\n" +
                "Turning 90.00 degrees clockwise (instruction 2)\r\n" +
                "I'm at (0.00, 10.00) facing 90.00 degrees\r\n" +
                "Moving 5.00 meters forward (instruction 3)\r\n" +
                "I'm at (5.00, 10.00) facing 90.00 degrees\r\n" +
                "Turning 90.00 degrees counterclockwise (instruction 4)\r\n" +
                "I'm at (5.00, 10.00) facing 0.00 degrees\r\n" +
                "Moving 10.00 meters forward (instruction 5)\r\n" +
                "I'm at (5.00, 20.00) facing 0.00 degrees\r\n";
        assertEquals(expectedOutput,outContent.toString());


    }


}
