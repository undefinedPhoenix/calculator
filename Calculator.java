import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;

import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    // window
    JFrame frame;
    // text-box
    JTextField textField;
    JButton[] numBtn = new JButton[10];
    JButton[] funBtn = new JButton[8];
    JButton addBtn, subBtn, mulBtn, divBtn;
    JButton decBtn, equBtn, delBtn, clearBtn;
    // handle Btn, textfield, event
    JPanel panel;

    Font myFont = new Font("Monospaced", Font.BOLD, 30);

    // calculation var
    double num1 = 0, num2 = 0, result = 0;
    int intResult = 0;
    String operator;

    // Constructor
    Calculator() {
        frame = new JFrame("Calculator");
        // exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set size
        frame.setSize(420, 550);
        frame.setLayout(null);
        // locate to center
        frame.setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setBackground(Color.white);
        // not editable
        textField.setEditable(false);

        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        decBtn = new JButton(".");
        equBtn = new JButton("=");
        delBtn = new JButton("Del");
        clearBtn = new JButton("Clear");

        funBtn[0] = addBtn;
        funBtn[1] = subBtn;
        funBtn[2] = mulBtn;
        funBtn[3] = divBtn;
        funBtn[4] = decBtn;
        funBtn[5] = equBtn;
        funBtn[6] = delBtn;
        funBtn[7] = clearBtn;

        for (int i = 0; i < 8; i++) {
            funBtn[i].addActionListener(this);
            funBtn[i].setFont(myFont);
            // remove outline when cursor on top
            funBtn[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numBtn[i] = new JButton(String.valueOf(i));
            numBtn[i].addActionListener(this);
            numBtn[i].setFont(myFont);
            numBtn[i].setFocusable(false);
        }

        delBtn.setBounds(50, 430, 145, 50);
        clearBtn.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numBtn[1]);
        panel.add(numBtn[2]);
        panel.add(numBtn[3]);
        panel.add(addBtn);
        panel.add(numBtn[4]);
        panel.add(numBtn[5]);
        panel.add(numBtn[6]);
        panel.add(subBtn);
        panel.add(numBtn[7]);
        panel.add(numBtn[8]);
        panel.add(numBtn[9]);
        panel.add(mulBtn);
        panel.add(decBtn);
        panel.add(numBtn[0]);
        panel.add(equBtn);
        panel.add(divBtn);

        frame.add(panel);
        frame.add(delBtn);
        frame.add(clearBtn);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // number
        for (int i = 0; i < 10; i++) {            
            if(e.getSource() == numBtn[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        // funBtn
        if(e.getSource() == decBtn) {
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource() == addBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = "+";
            textField.setText("");
        }

        if(e.getSource() == subBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = "-";
            textField.setText("");
        }

        if(e.getSource() == mulBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = "*";
            textField.setText("");
        }

        if(e.getSource() == divBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = "/";
            textField.setText("");
        }

        if(e.getSource() == equBtn) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
            }
            
            // cancel .00
            if (result % 1 == 0) {
                intResult = (int)result;
                textField.setText(String.valueOf(intResult));
            } else {
                textField.setText(String.valueOf(result));
            }
        }

        // clear
        if(e.getSource() == clearBtn) {
            textField.setText(null);
        }

        // del 
        if(e.getSource() == delBtn) {
            String string = textField.getText();
            textField.setText(string.substring(0, string.length() - 1));
        }
    }
}