// import libraries for implementing calculator

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;


    Font myFont = new Font("Ink Free", Font.BOLD, 30);


    double number1 = 0, number2 = 0, result = 0;
    char operator;

    Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);


        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);


        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("-");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equButton;
        functionButton[6] = delButton;
        functionButton[7] = clrButton;
        functionButton[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }

        delButton.setBounds(50, 450, 80, 50);
        clrButton.setBounds(160, 450, 80, 50);
        negButton.setBounds(270, 450, 80, 50);


        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }


        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.gray);


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


        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);


        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decButton) {
            textField.setText((textField.getText().concat(".")));
        }

        if(e.getSource() == addButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if(e.getSource() == subButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if(e.getSource() == mulButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if(e.getSource() == divButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

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

        if(e.getSource() == clrButton) {
            textField.setText("");
        }

        if(e.getSource() == delButton) {
            String temp = textField.getText();
            textField.setText("");
            for(int i = 0; i < temp.length() - 1; i++) {
                textField.setText(textField.getText() + temp.charAt(i));
            }
        }

        if(e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }

    }
}
