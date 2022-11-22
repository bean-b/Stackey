package testing;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;


import src.InputManager;
import src.Parser;

public class Tester {

    @Test
    public void testPrintSimple() throws IOException{
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        Parser parser = new Parser(ps);
        String toTest = "7\r\n.print";
        InputManager.parseFile(toTest, parser);
        String output = os.toString("UTF8");
        assertEquals("7", output);
    }
}
