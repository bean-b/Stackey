package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class InputManager{
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser(System.out);
        parseFile("inputs\\Input.txt", parser);

    }

    public static void parseFile(String fileName, Parser parser) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<String> data = new ArrayList<>();
        String curLine = "";
        while((curLine = reader.readLine()) != null){;
            data.add(curLine);
        }
        reader.close();
        parser.Interpret(data);
    }
}