/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.advisedcourses;

import java.sql.*;
public class Driver {
    public static ResultSet test(String tb){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advising", "root", "root");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from "+tb);
            //while(rs.next()){
            //    System.out.println(rs.getString("section_id")+" "+rs.getString("faculty_initial"));
            //}
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static boolean insertStd(String id, String fn, String ln, String ad, String d){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advising", "root", "root");
            Statement stm = conn.createStatement();
            stm.executeUpdate("insert into student values('"+id+"','"+fn+"','"+ln+"','"+ad+"','"+d+"')");
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }
    
    public static boolean insertFac(String name, String in, String d){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advising", "root", "root");
            Statement stm = conn.createStatement();
            stm.executeUpdate("insert into faculty values('"+name+"','"+in+"','"+d+"')");
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
