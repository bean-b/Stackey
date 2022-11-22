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
    }

    @Test
    public void testSimpleMaths() throws IOException{
        String toTest = "1\r\n2\r\n.+\r\n5\r\n.*\r\n3\r\n.-\r\n5\r\n.%\r\n2\r\n.^\r\n.++\r\n.++\r\n.--\r\n.print";
        InputManager.parseFile(toTest, parser);
        String output = os.toString("UTF8");
        assertEquals("5", output);
    }

    @Test
    public void testPrintAll() throws IOException{
        String toTest = "1\r\n2\r\n3\r\n4\r\n5\r\n.sizeOfStack\r\n.doFor\r\n.print";
        InputManager.parseFile(toTest, parser);
        String output = os.toString("UTF8");
        assertEquals("54321", output);
    }
    @Test
    public void testVariables() throws IOException{
        String toTest = "2\r\n>x\r\n\"hello world \r\n<x\r\n.doFor\r\n.duplicate\r\n.sizeOfStack\r\n.doFor\r\n.print\r\n#and A comment for Fun";
        InputManager.parseFile(toTest, parser);
        String output = os.toString("UTF8");
        assertEquals("hello world hello world hello world ", output);
    }

    @Test
    public void testRange() throws IOException{
        String toTest = "5\r\n.++\r\n1\r\n.range\r\n.sizeOfStack\r\n.--\r\n.doFor\r\n.*\r\n.print";
        InputManager.parseFile(toTest, parser);
        String output = os.toString("UTF8");
        assertEquals("120", output);
    }
}
