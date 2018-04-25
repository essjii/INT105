package view;

import controller.CalculateGPAListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GPACal {
    
    private JFrame gpaFrame;
    private JLabel coursesLabel;
    private JLabel gradeLabel;
    private JLabel creditsLabel;
    private JLabel[] subject;
    private JTextField[] gradeTxt;
    private JTextField[] creditsTxt;
    private JLabel gpaLabel;
    private JTextField gpaTxt;
    private JButton calculateBtn;
    
    public GPACal() {
        initGUI();
    }
    
    public void initGUI() {
        gpaFrame = new JFrame("GPA Calculator");
        coursesLabel = new JLabel("Courses");
        gradeLabel = new JLabel("Grade");
        creditsLabel = new JLabel("Credits");
        
        subject = new JLabel[]{new JLabel("INT105"), new JLabel("INT106"), new JLabel("INT107"),
            new JLabel("GEN111"), new JLabel("MTH111"), new JLabel("LNG103")};
        
        gradeTxt = new JTextField[]{new JTextField("A"), new JTextField("A"), new JTextField("A"),
            new JTextField("A"), new JTextField("A"), new JTextField("A")};
        
        creditsTxt = new JTextField[]{new JTextField("3.0"), new JTextField("3.0"), new JTextField("3.0"),
            new JTextField("3.0"), new JTextField("3.0"), new JTextField("3.0")};
        
        gpaLabel = new JLabel("GPA");
        gpaTxt = new JTextField("0.00");
        calculateBtn = new JButton("Calculate");
    }
    
    public void LoadGPAForm() {
        JPanel GPAPanel = new JPanel();
        GridLayout grid = new GridLayout(8, 3);
        GPAPanel.setLayout(grid);
        
        GPAPanel.add(coursesLabel);
        GPAPanel.add(gradeLabel);
        GPAPanel.add(creditsLabel);
        
        for (int i = 0; i < subject.length; i++) {
            GPAPanel.add(subject[i]);
            GPAPanel.add(gradeTxt[i]);
            GPAPanel.add(creditsTxt[i]);
        }
        
        GPAPanel.add(gpaLabel);
        GPAPanel.add(gpaTxt);
        
        JPanel calPanel = new JPanel();
        calPanel.add(calculateBtn);
        FlowLayout flow = new FlowLayout();
        flow.setAlignment(FlowLayout.RIGHT);
        
        CalculateGPAListener cl = new CalculateGPAListener(gradeTxt,creditsTxt,gpaTxt);
        calculateBtn.addActionListener(cl);
        
        gpaFrame.add(GPAPanel, BorderLayout.NORTH);
        gpaFrame.add(calPanel, BorderLayout.CENTER);
        
        gpaFrame.setSize(1000, 1000);
        gpaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gpaFrame.pack();
        gpaFrame.setVisible(true);
    }
}
