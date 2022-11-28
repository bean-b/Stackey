package GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.*;

import src.InputManager;
import src.Parser;

public class GUI{
    private static final float FONT_SIZE = 14f;
    private static JFrame frame;
    private static JTextArea textField;
    private static JTextArea outPutField;
    private static Parser parser;
    private static ByteArrayOutputStream os;
    // private static JTextArea theStackField;
    public static void main(String[] args) {
        constructGUI();
        os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        parser = new Parser(ps);

    }

    private static void constructGUI(){
        frame = new JFrame("Stackey");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
 
        JPanel panel = new JPanel();
 
 
        textField = new JTextArea(25, 25);
        textField.setFont(textField.getFont().deriveFont(FONT_SIZE));
        outPutField = new JTextArea(25, 25);
        outPutField.setEditable(false);
        outPutField.setFont(outPutField.getFont().deriveFont(FONT_SIZE));
        // theStackField = new JTextArea(25, 25);
        // theStackField.setEditable(false);
        JButton runAllButton = new JButton("Run All");
        runAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(textField.getText().equals("")){
                        outPutField.setText("");
                    }else{
                        InputManager.parseFile(textField.getText().replaceAll("\n", System.lineSeparator()), parser);
                        String output = os.toString("UTF8");
                        outPutField.setText(output);
                        os.reset();
                    }
                } catch (IOException e1) {
                    // e1.printStackTrace();
                }
            }
         });
        JButton clearAllButton = new JButton("Clear All");
        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outPutField.setText("");
            }
         });
        // JButton incrementButton = new JButton("Increment Line");
        panel.add(textField);
        panel.add(runAllButton);
        panel.add(clearAllButton);
        // panel.add(incrementButton);
        panel.add(outPutField);
        // panel.add(theStackField);
 
 
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
