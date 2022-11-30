package testing;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import src.InputManager;
import src.Parser;

public class Tester {

    ByteArrayOutputStream os;
    PrintStream ps;
    Parser parser;

    @BeforeEach
    public void BeforeEach(){
        os = new ByteArrayOutputStream();
        ps = new PrintStream(os);
        parser = new Parser(ps);
    }

    @Test
    public void testPrintSimple() throws IOException{
        String toTest = "7\r\n.print";
        InputManager.parseFile(toTest, parser);
        String output = os.toString("UTF8");
        assertEquals("7", output);
        parser.close();
    }

    @Test
    public void testSimpleMaths() throws IOException{
        String toTest = "1\r\n2\r\n.+\r\n5\r\n.*\r\n3\r\n.-\r\n5\r\n.%\r\n2\r\n.^\r\n.++\r\n.++\r\n.--\r\n.print";
        InputManager.parseFile(toTest, parser);
        String output = os.toString("UTF8");
        assertEquals("5", output);
        parser.close();
    }

    @Test
    public void testPrintAll() throws IOException{
        String toTest = "1\r\n2\r\n3\r\n4\r\n5\r\n.sizeOfStack\r\n.for\r\n{\r\n.print\r\n}";
        InputManager.parseFile(toTest, parser);
        String output = os.toString("UTF8");
        assertEquals("54321", output);
        parser.close();
    }
    
    @Test
    public void testVariables() throws IOException{
        String toTest = "2\r\n>x\r\n\"hello world \r\n<x\r\n.for\r\n{\r\n.duplicate\r\n}\r\n.sizeOfStack\r\n.for\r\n{\r\n.print\r\n}\r\n#and A comment for Fun";
        InputManager.parseFile(toTest, parser);
        String output = os.toString("UTF8");
        assertEquals("hello world hello world hello world ", output);
        parser.close();
    }

    @Test
    public void testRange() throws IOException{
        String toTest = "1\r\n5\r\n.++\r\n.range\r\n.sizeOfStack\r\n.--\r\n.for\r\n{\r\n.*\r\n}\r\n.print";
        InputManager.parseFile(toTest, parser);
        String output = os.toString("UTF8");
        assertEquals("120", output);
        parser.close();
    }
    @Test
    public void testFancyFor() throws IOException{
        String toTest = "2\r\n3\r\n2\r\n.for\r\n{\r\n4\r\n.+\r\n2\r\n.*\r\n.print\r\n}";
        InputManager.parseFile(toTest, parser);
        String output = os.toString("UTF8");
        assertEquals("1412", output);
        parser.close();
    }
    @Test
    public void testNestedFor() throws IOException{
        String toTest = "0\r\n>x\r\n22\r\n.for\r\n{\r\n8\r\n.for\r\n{\r\n<x\r\n.++\r\n>x\r\n}\r\n}\r\n<x\r\n.print";
        InputManager.parseFile(toTest, parser);
        String output = os.toString("UTF8");
        assertEquals("176", output);
        parser.close();
    }
}
