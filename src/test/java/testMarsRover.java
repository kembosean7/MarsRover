import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.example.*;

import java.io.FileNotFoundException;
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


}
