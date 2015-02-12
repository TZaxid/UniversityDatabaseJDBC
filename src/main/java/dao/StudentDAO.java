package dao;

import java.sql.*;
import java.util.ArrayList;

import pogo.Student;
import utils.JdbcConnect;

public class StudentDAO {
    private final static String[] COLUMS  = {"surname", "name", "fname", "student_id", "group_id"};
    private final static String TABLE = "students";

    public static ArrayList<Student> getAllRecords() {
        ArrayList<Student> students = null;
        try (Connection conn = JdbcConnect.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM " + TABLE + " ORDER BY surname");
            while (result.next()) {
                Student record = new Student(result.getString("surname"),
                        result.getString("name"), result.getString("fname"),
                        result.getInt("student_id"), result.getInt("group_id"));
                students.add(record);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Some problem with database");
            e.printStackTrace();
        } finally {
            return students;
        }
    }

    public static void insertStudent(Student student) {
        try (Connection conn = JdbcConnect.getConnection()) {
            PreparedStatement prepSt = conn.prepareStatement("INSERT INTO students VALUES (?, ?, ?, ?, ?)");
            prepSt.setString(1, student.getSurname());
            prepSt.setString(2, student.getName());
            prepSt.setString(3, student.getFname());
            prepSt.setInt(4, student.getStudentId());
            prepSt.setInt(5, student.getGroupId());
            prepSt.executeUpdate();
            prepSt.close();
        } catch (SQLException e) {
            System.out.println("Insert error");
            e.printStackTrace();
        }
    }

    public static void deleteStudentById(int id) {
        try (Connection conn = JdbcConnect.getConnection()) {
            PreparedStatement prepSt = conn.prepareStatement("DELETE FROM " + TABLE + " WHERE student_id = " + id);
            prepSt.executeUpdate();
            prepSt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Student getStudentById(int id) {
        Student student = null;
        try (Connection conn = JdbcConnect.getConnection()) {
            PreparedStatement prepSt = conn.prepareStatement("SELECT * FROM " + TABLE + " WHERE id = " + id);
            ResultSet result = prepSt.executeQuery();
            if (result.next()) {
                student = new Student(result.getString("surname"),
                        result.getString("name"), result.getString("fname"),
                        result.getInt("student_id"), result.getInt("group_id"));
            }
            prepSt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return student;
        }
    }

    public static void updateStudent(Student student, int oldId) {
        try (Connection conn = JdbcConnect.getConnection()) {
            PreparedStatement prepSt = conn.prepareStatement(
                "UPDATE " + TABLE + " SET surname = ?, "
                + "name = ?, fname = ?, student_id = ?, group_id = ? "
                + "WHERE student_id = " + oldId
            );
            prepSt.setString(1, student.getSurname());
            prepSt.setString(2, student.getName());
            prepSt.setString(3, student.getFname());
            prepSt.setInt(4, student.getStudentId());
            prepSt.setInt(5, student.getGroupId());
            prepSt.executeUpdate();
            prepSt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
