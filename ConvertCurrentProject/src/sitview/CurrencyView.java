/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sitview;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author INT105
 */
public class CurrencyView {
    
    private JFrame currFrame;
    private JLabel usLabel;
    private JLabel bahtLabel;
    private JTextField usTxtField;
    private JTextField bahtTxtField;
    private JButton convertBtn;

    public CurrencyView(){
        initGui();
    }
    
    public void initGui(){
        currFrame = new JFrame("US to Baht Currency Convert");
        usLabel = new JLabel("US Dollar($)");
        bahtLabel = new JLabel("Baht");
        usTxtField = new JTextField("1"); //number of column
        bahtTxtField = new JTextField("31.50");
        convertBtn = new JButton("convert"); 
    }
    
    public void loadCurrencyForm(){
        GridLayout grid = new GridLayout(3, 2); //(row,column)
        currFrame.setLayout(grid);
        //1st row
        currFrame.add(usLabel);
        currFrame.add(usTxtField);
        //2nd row
        currFrame.add(bahtLabel);
        currFrame.add(bahtTxtField);
        //3rd row
        currFrame.add(convertBtn);
        //set Frame properties (defult size is (0,0), visible is false)
        currFrame.setSize(200, 200); //(widht, height)
        currFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        currFrame.pack(); //ลดขนาดเฟรมลงให้เล็กที่สุดเท่าที่จะแสดง component ทั้งหมดได้
        currFrame.setVisible(true);
    }
    
    
}
