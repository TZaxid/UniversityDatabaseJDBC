package controller;

import dao.StudentDAO;
import pogo.Student;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        ArrayList<Student> stud; //new ArrayList<Student>();
        stud = StudentDAO.getAllRecords();
        for (Student s : stud) {
            System.out.println(s.getSurname() + " " + s.getName() + " " + s.getFname() + " " + s.getStudentId() + " " + s.getGroupId());
        }
    }
}
