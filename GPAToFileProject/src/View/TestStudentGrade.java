
package View;

import model.StudentGrade;


public class TestStudentGrade {
    public static void main(String[] args) {
        StudentGrade myGrade[] = new StudentGrade[6];
        myGrade[0] = new StudentGrade("MTH111","A",3);
        myGrade[1] = new StudentGrade("LNG103","B",3);
        myGrade[2] = new StudentGrade("INT107","B+",3);
        myGrade[3] = new StudentGrade("GEN111","A",3);
        myGrade[4] = new StudentGrade("INT105","A",3);
        myGrade[5] = new StudentGrade("INT106","A",3);
        StudentGradeView sgv = new StudentGradeView(myGrade);
        
    }
}
