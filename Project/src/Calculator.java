// Import libraries for implementing calculator
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Calculator class implementing ActionListener interface
public class Calculator implements ActionListener{

    // Instance variables
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("Arial", Font.BOLD, 30); // Font for the calculator display
    double number1 = 0, number2 = 0, result = 0;
    char operator;

    // Constructor for the Calculator class
    Calculator() {
        // Initialize JFrame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        // Initialize JTextField for display
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        // Initialize buttons for arithmetic operations, decimal, and other functions
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("-");

        // Assign buttons to arrays for easy access
        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equButton;
        functionButton[6] = delButton;
        functionButton[7] = clrButton;
        functionButton[8] = negButton;

        // Loop through function buttons to add ActionListener and set font
        for (int i = 0; i < 9; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }

        // Set bounds for function buttons
        delButton.setBounds(50, 420, 90, 50);
        clrButton.setBounds(155, 420, 90, 50);
        negButton.setBounds(260, 420, 90, 50);

        // Initialize and add ActionListener to numeric buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Initialize JPanel for button layout
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add components to the frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Main method to instantiate the Calculator object
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    // ActionListener interface method implementation
    @Override
    public void actionPerformed(ActionEvent e) {
        // Action handling for numeric buttons
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        // Action handling for decimal button
        if(e.getSource() == decButton) {
            textField.setText((textField.getText().concat(".")));
        }

        // Action handling for arithmetic operation buttons
        if(e.getSource() == addButton || e.getSource() == subButton ||
                e.getSource() == mulButton || e.getSource() == divButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = e.getActionCommand().charAt(0); // Get the operator from the button text
            textField.setText("");
        }

        // Action handling for equals button
        if(e.getSource() == equButton) {
            number2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    result = number1 / number2;
                    break;
            }
            textField.setText(String.valueOf(result));
            number1 = result;
        }

        // Action handling for clear button
        if(e.getSource() == clrButton) {
            textField.setText("");
        }

        // Action handling for delete button
        if(e.getSource() == delButton) {
            String temp = textField.getText();
            textField.setText("");
            for(int i = 0; i < temp.length() - 1; i++) {
                textField.setText(textField.getText() + temp.charAt(i));
            }
        }

        // Action handling for negative button
        if(e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}