/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JTextField;

/**
 *
 * @author INT105
 */
public class CalculateListener implements ActionListener {

    private JTextField txtGrades[];
    private JTextField txtCredits[];
    private JTextField txtGPA;

    public CalculateListener(JTextField[] grades, JTextField[] credits, JTextField gpa) {
        txtGrades = grades;
        txtCredits = credits;
        txtGPA = gpa;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       //ทำ action แยกให้แต่ละปุ่ม โดยตั้ง if else ว่าถ้ากดปุ่มนี้แล้วจะทำแบบนี้
        if(e.getActionCommand().equals("Calculate")){
            calculateGrade();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Save")){
            saveToDataFile();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Save As Object")){
            saveToObjectFile();
        }
    }
    
    public void saveToDataFile(){
        System.out.println("Saving To Data File...");
    }
    
    public void saveToObjectFile(){
        System.out.println("Saving To Object File...");
    }
    
    public void calculateGrade(){
        System.out.println("Calculating...");
            float totalGrade = 0;
            float totalCredit = 0;
            float gpa = 0;
            for(int i = 0; i < txtGrades.length; i++){
                float grade = convertGrade(txtGrades[i].getText());
                float credit = Float.parseFloat(txtCredits[i].getText());
                totalGrade += grade*credit;
                totalCredit += credit;
                gpa = totalGrade/totalCredit;
                DecimalFormat formatGPA = new DecimalFormat("0.##");
                txtGPA.setText(formatGPA.format(gpa));
            }
    }
    
    public float convertGrade(String gradeString){
        float grade = 0;
        switch (gradeString){
            case "A":
                    grade = 4.0f;
                    break;   
                case "B+":
                    grade = 3.5f;
                    break;
                case "B":
                    grade = 3.0f;
                    break;
                case "C+":
                    grade = 2.5f;
                    break;
                case "C":
                    grade = 2.0f;
                    break;
                case "D+":
                    grade = 1.5f;
                    break;
                case "D":
                    grade = 1.0f;
                    break;
                case "F":
                    grade = 0.0f;
                    break;       
        }
        return grade;
    }
}
