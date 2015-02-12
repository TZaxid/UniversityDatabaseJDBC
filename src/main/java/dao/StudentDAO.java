package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pogo.Student;
import utils.JdbcConnect;

public class StudentDAO {
    private final static String[] COLUMS  = {"surname", "name", "fname", "student_id", "group_id"};
    private final static String TABLE = "students";
//    private Statement st;
//    private ResultSet result;
//    private Connection conn;
//    private ArrayList<Student> students;

    public static ArrayList<Student> getAllRecords() {
        ArrayList<Student> students = null;
        Statement st = null;
        Connection conn = null;
        ResultSet result = null;
        try {
            conn = JdbcConnect.getConnection();
            result = st.executeQuery("SELECT * FROM " + TABLE + " ORDER BY surname");
            while (result.next()) {
                Student record = new Student(result.getString("surname"),
                        result.getString("name"), result.getString("fname"),
                        result.getInt("student_id"), result.getInt("group_id"));
                students.add(record);
            }
        } catch (SQLException e) {
            System.out.println("Some problem with database");
            e.printStackTrace();
        } finally {
            return students;
        }
    }
}
