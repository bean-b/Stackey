package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class InputManager{
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser(System.out);
        parseFile(new FileReader("inputs\\Input.txt"), parser);
        parser.close();

    }

    public static void parseFile(FileReader file, Parser parser) throws IOException{
        BufferedReader reader = new BufferedReader(file);
        List<String> data = new ArrayList<>();
        String curLine = "";
        while((curLine = reader.readLine()) != null){;
            data.add(curLine);
        }
        reader.close();
        parser.Interpret(data);
    }
    public static void parseFile(String text, Parser parser) throws IOException{
        List<String> data = new ArrayList<>();
        String[] lines = text.split(System.lineSeparator());
        for (String string : lines) {
            data.add(string);
        }
        parser.Interpret(data);
    }
}