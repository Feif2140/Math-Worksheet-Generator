import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionTypes extends JFrame implements ActionListener {
    JRadioButton addition, subtraction, multiplication, division, ones, tens, hundreds;
    ButtonGroup operator, digits;
    JButton settings = new JButton("Apply Options");
    JLabel questionType = new JLabel("Arithmetic operator:");
    JLabel intSize = new JLabel("Number of digits: ");
    String symbol = "";
    int digit = 0;
    int lower=0;

    public QuestionTypes () {
        this.setLayout(null);

        questionType.setBounds(30, 10, 160, 20);
        intSize.setBounds(30,160, 160, 20);
        settings.setBounds(30, 275, 140, 30);

        operator = new ButtonGroup();
        addition = new JRadioButton();
        subtraction = new JRadioButton();
        multiplication = new JRadioButton();
        division = new JRadioButton();
        addition.setText("addition question set");
        subtraction.setText("subtraction question set");
        multiplication.setText("multiplication question set");
        division.setText("division question set");
        addition.setBounds(40,40,300,20);
        subtraction.setBounds(40,70,300,20);
        multiplication.setBounds(40,100,300,20);
        division.setBounds(40,130,300,20);
        operator.add(addition);
        operator.add(subtraction);
        operator.add(multiplication);
        operator.add(division);
        this.add(questionType);
        this.add(addition);
        this.add(subtraction);
        this.add(multiplication);
        this.add(division);
        this.add(intSize);


        digits = new ButtonGroup();
        ones = new JRadioButton();
        tens = new JRadioButton();
        hundreds = new JRadioButton();
        digits.add(ones);
        digits.add(tens);
        digits.add(hundreds);
        ones.setText("single digits");
        tens.setText("double digits");
        hundreds.setText("triple digits");
        ones.setBounds(40,190,160,20);
        tens.setBounds(40,220,160,20);
        hundreds.setBounds(40,250,160,20);
        this.add(ones);
        this.add(tens);
        this.add(hundreds);
        this.add(settings);
        settings.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (addition.isSelected()) {
            symbol = " + ";
        }
        if (subtraction.isSelected()) {
            symbol = " - ";
        }
        if (multiplication.isSelected()) {
            symbol = " × ";
        }
        if (division.isSelected()) {
            symbol = " ÷ ";
        }
        if (ones.isSelected()){
            digit = 10;
            lower = 0;
        }
        if (tens.isSelected()){
            digit = 89;
            lower = 10;
        }
        if (hundreds.isSelected()){
            digit = 899;
            lower = 100;
        }

        Demo f = new Demo(symbol, digit, lower);
        f.setBounds(100,100,800,800);
        f.setTitle("MathWorksheet");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public String getSymbol(){
        return symbol;
    }
    public int getDigit(){
        return digit;
    }

}

