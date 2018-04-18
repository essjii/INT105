/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import sit.db.ConnectionManager;
import sit.model.Course;

/**
 *
 * @author INT105
 */
public class CourseController {

    private Connection con;
    
    public CourseController(String fileName) throws IOException, FileNotFoundException, SQLException{
        con = ConnectionManager.createConnection(fileName);
    }

    public CourseController(String username, String psw) throws ClassNotFoundException, SQLException {
        con = ConnectionManager.createConnection("jdbc:derby://localhost:1527/course", username, psw);
    }
    
    public void executeSQLFromUsre(String sql) throws SQLException{
        //ไม่ควรทำใน Application เพราะไม่มีการรักษาความปลอดภัยเลย
        Statement stmt = con.createStatement();
        boolean hasResultSet = stmt.execute(sql);
        
        if(hasResultSet) {
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                
            String cId = rs.getString("courseId");
            String cName = rs.getString("courseName");
            Course cTmp = new Course(cId, cName);
            //System.out.println(cTmp);
            }
        }
    }

    public ArrayList<Course> selectCourses() throws SQLException {
        ArrayList<Course> courseList = new ArrayList<Course>();
        
        Statement stmt = con.createStatement();
        String sql = "select * from course";
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            //orm ---> Object Relational Mapping
            String cId = rs.getString("courseId");
            String cName = rs.getString("courseName");
            Course cTmp = new Course(cId, cName);
            //System.out.println(cTmp);
            courseList.add(cTmp); //add into ArrayList
        }
        return courseList;
    }
    
    public void createCourseTable() throws SQLException {
        String sql = "create table course"
                + " (courseId varchar(6),"
                + " courseName varchar(50),"
                + "primary key(courseId))";
        System.out.println(sql);

        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
        System.out.println("create table course successfully");
    }

    public void dropCourseTable() throws SQLException {
        String sql = "drop table course";
        System.out.println(sql);

        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
        System.out.println("drop table course successfully");
    }

    public int insertFromFile(String fileName) throws FileNotFoundException, SQLException {
        Scanner scFile = new Scanner(new File(fileName));
        scFile.useDelimiter(",");
        int insertedRecs = 0;
        
        PreparedStatement pStmt = con.prepareStatement("insert into course(courseId,courseName) values(?,?)");

        while (scFile.hasNext()) {
            //System.out.println(scFile.next());
            String cId = (scFile.next()).trim();
            //set cId to the first question mark
            String cName = (scFile.next()).trim();
            //set cName to the second question mark
            
            pStmt.setString(1, cId);
            //set cId to the first question mark
            pStmt.setString(2, cName);
            //set cName to the second question mark
            insertedRecs += pStmt.executeUpdate();
            
            System.out.println(insertedRecs + " inserted Recs");
            
//            Course cTmp = new Course(cId, cName);
//            insertedRecs += insertCourse(cTmp);
        }
        
//        Statement stmt = con.createStatement();
//        insertedRec = stmt.executeUpdate(scFile.next());
//        System.out.println(insertedRec + "insert successfully");

        return insertedRecs;
    }

    public int insertCourse(Course subject) throws SQLException {
        String sql = "insert into course (courseId,courseName) values("
                + "'" + subject.getCourseId() + "','" + subject.getCourseName() + "')";
        System.out.println(sql);

        Statement stmt = con.createStatement();
        int insertedRec = stmt.executeUpdate(sql);
        System.out.println(insertedRec + "insert successfully");
        return insertedRec;
    }

    public void closeCourseConnection() throws SQLException {
        ConnectionManager.closeConnection(con);
    }
}
