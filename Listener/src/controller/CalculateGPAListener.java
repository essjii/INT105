package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JTextField;

public class CalculateGPAListener implements ActionListener {

    private JTextField[] gradeTxt;
    private JTextField[] creditsTxt;
    private JTextField gpaTxt;

    public CalculateGPAListener(JTextField[] gradeTxt, JTextField[] creditsTxt, JTextField gpaTxt) {
        this.gradeTxt = gradeTxt;
        this.creditsTxt = creditsTxt;
        this.gpaTxt = gpaTxt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        double totalCredits = 0;
        double totalGrade = 0;
        
        for (int i = 0; i < gradeTxt.length; i++) {
            double credits = Double.parseDouble(creditsTxt[i].getText());
            double grade = 0;
            switch (gradeTxt[i].getText()) {
                case "A":
                    grade = 4.0;
                    break;
                case "B+":
                    grade = 3.5;
                    break;
                case "B":
                    grade = 3.0;
                    break;
                case "C+":
                    grade = 2.5;
                    break;
                case "C":
                    grade = 2.0;
                    break;
                case "D+":
                    grade = 1.5;
                    break;
                case "D":
                    grade = 1.0;
                    break;
                case "F":
                    grade = 0.0;
                    break;
            }
            
            totalCredits += credits;
            totalGrade += grade*credits;
        }
        
        double gpa = totalGrade/totalCredits;
        DecimalFormat format = new DecimalFormat("#.00");
        gpaTxt.setText(gpa+"");
    }
}
