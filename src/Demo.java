import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Demo extends JFrame implements ActionListener{

    JButton checkButton=new JButton("Check");
    JLabel L1 = new JLabel("Score");
    JLabel comment = new JLabel("");

    JTextField studentAns[] = new JTextField[10];
    JLabel ansKey[] = new JLabel[10];
    JLabel question[] = new JLabel[10];
    JLabel checkLabel[] = new JLabel[10];
    JLabel correctAns[] = new JLabel[10];

    int op1[]=new int[10] ;
    int op2[]=new int [10];
    public int[] arr = new int [10];
    public int correctAnswer;
    public int numCorrect;
    int max;



    public Demo(String symbol, int numberSize, int lower) {

        this.setLayout(null);


            checkButton.setBounds(155, 390, 80, 30);

            L1.setBounds(250, 390, 80, 50);

            for (int i = 0; i < 10; i++) {
                op1[i]= (int)Math.round(lower + (Math.random()*numberSize));
                op2[i]= (int)Math.round(lower + (Math.random()*numberSize));
                correctAnswer = op1[i] + op2[i];
                int number1 = op1[i], number2 = op2[i];
                if (symbol.equals(" + ")) correctAnswer = op1[i] + op2[i];
                if (symbol.equals(" - ")) correctAnswer = op1[i] - op2[i];
                if (symbol.equals(" × ")) correctAnswer = op1[i] * op2[i];
                if (symbol.equals(" ÷ ")) {
                    number1 = op1[i]*op2[i];
                    number2 = op1[i];
                    correctAnswer = op2[i];
                }
//                if (symbol.equals(" ÷ ")) {
//                    if (numberSize==10){
//                        max = 10;
//                    }
//                    if (numberSize==89){
//                        max = 100;
//                    }
//                    if (numberSize==899){
//                        max = 1000;
//                    }
//                    while (op1[i]*op2[i] > max) {
//                        op1[i] = 0; op2[i] = 0;
//                        op1[i] = (int) Math.round(lower + (Math.random() * numberSize));
//                        op2[i] = (int) Math.round(lower + (Math.random() * numberSize));
//                    }
//                    number1 = op1[i]*op2[i];
//                    number2 = op1[i];
//                    correctAnswer = op2[i];
//                }
                arr[i] = correctAnswer;

                question[i] = new JLabel(" " + (i+1) +".   " + number1 + symbol + number2 + "= ");
                question[i].setBounds(30, 20 + 30 * i, 160, 20);
                this.add(question[i]);

                studentAns[i] = new JTextField("");
                studentAns[i].setBounds(150, 20 + 30 * i, 50, 20);
                this.add(studentAns[i]);


                checkLabel[i]= new JLabel((""));
                checkLabel[i].setBounds(250, 20 + 30 * i, 60, 20);
                this.add(checkLabel[i]);

                ansKey[i] = new JLabel("");
                ansKey[i].setBounds(350, 20 + 30 * i, 150, 20);
                this.add(ansKey[i]);

                correctAns[i] = new JLabel("");
                correctAns[i].setBounds(450, 20+30*i, 100, 20);
                this.add(correctAns[i]);

            }

            this.add(checkButton);
            checkButton.addActionListener(this);
            this.add(L1);
            comment.setBounds(250, 425, 500, 50);
            this.add(comment);

    }

    public void actionPerformed( ActionEvent evt) {

        if (evt.getSource().equals(checkButton)) {

            for (int i = 0; i < 10; i++) {

                int rel = Integer.parseInt(studentAns[i].getText());
                int rightAnswer = arr[i];
                if (Math.abs(rel - rightAnswer) < 0.0001) {
                    checkLabel[i].setText("Y");
                    numCorrect++;
                } else {
                    checkLabel[i].setText("X");

                    ansKey[i].setText("answer " + (i + 1) + ": ");
                    correctAns[i].setText(String.valueOf(arr[i]));
                }

                L1.setText("Score: " + (String.valueOf(numCorrect)) + "0% correct");
            }
            switch (numCorrect) {

                case (10):
                    comment.setText("Perfect! You're really good at addition!");
                    break;
                case (9):
                    comment.setText("Excellent! nearly perfect!");
                    break;
                case (8):
                    comment.setText("Great job, really good score ");
                    break;
                case (7):
                    comment.setText("Good job, maybe study more, but good effort");
                    break;
                case (6):
                case (5):
                    comment.setText("i think you need to review the course material, but don't give up!");
                    break;
                case (4):
                case (3):
                case (2):
                case (1):
                case (0):
                    comment.setText("keep studying, you will get better :)");
                    break;

            }
        }
        checkButton.removeActionListener(this);
    }
}

