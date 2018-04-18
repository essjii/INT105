/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import sit.controller.CourseController;
import sit.model.Course;

/**
 *
 * @author INT105
 */
public class TestCourseDB {
    public static void main(String[] args) {
        try{
            /*CourseController courseCtrl = new CourseController("sit", "sit");
            courseCtrl.executeSQLFromUsre("Select * from course where courseId = 'GEN111'");
            courseCtrl.executeSQLFromUsre("update course set courseName = 'Strong Man' where courseId = 'GEN111'");
//            courseCtrl.dropCourseTable();
//            courseCtrl.createCourseTable();

//            Course c1 = new Course("INT105", "Computer Programming II");
//            int insertedRec = courseCtrl.insertCourse(c1);
//            System.out.println(insertedRec+"Insert Record");

//            courseCtrl.insertFromFile("courseList.txt");
            
//            ArrayList<Course> cList = courseCtrl.selectCourses();
            //การ update or แก้ข้อมูลลงบน data base
            
//            for (int i = 0; i < cList.size(); i++) {
//                System.out.println(cList.get(i));
//                String cName = cList.get(i).getCourseName();
//                if(cName.equalsIgnoreCase("GEN111")){
//                    cList.get(i).setCourseName("Strong Man");
//                }
//            }
            courseCtrl.closeCourseConnection();*/
            
            CourseController courseCtrl = new CourseController("db.properties");
            System.out.println("Connection created");
            ArrayList<Course> courseList=courseCtrl.selectCourses();
            for(Course course : courseList){
                System.out.println(course);
            }
        }
//        catch(ClassNotFoundException cnf){
//            System.out.println(cnf);
//        }
        catch(SQLException cnf){
            System.out.println(cnf);
        }
        
        catch(IOException io){
            System.out.println(io);
        }
//        catch(FileNotFoundException fnf){
//            System.out.println(fnf);
//        }
    }
}
