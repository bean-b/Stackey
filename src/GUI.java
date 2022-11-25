package src;


import javax.swing.*;

public class GUI{
    private static JFrame frame;
    private static JTextArea textField;
    private static JTextArea outPutField;
    private static JTextArea theStackField;
    public static void main(String[] args) {
        constructGUI();
    }

    private static void constructGUI(){
        frame = new JFrame("Stackey");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
 
        JPanel panel = new JPanel();
 
 
        textField = new JTextArea(25, 25);
        outPutField = new JTextArea(25, 25);
        outPutField.setEditable(false);
        theStackField = new JTextArea(25, 25);
        theStackField.setEditable(false);
        JButton runAllButton = new JButton("Run All");
        JButton incrementButton = new JButton("Increment Line");
        panel.add(textField);
        panel.add(runAllButton);
        panel.add(incrementButton);
        panel.add(outPutField);
        panel.add(theStackField);
 
 
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
