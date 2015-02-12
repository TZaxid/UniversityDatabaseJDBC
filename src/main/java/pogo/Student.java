package pogo;

public class Student {
    private String surname;
    private String name;
    private String fname;
    private int studentId;
    private int groupId;

    public Student(String surname, String name, String fname, int studentId, int groupId) {
        this.surname = surname;
        this.name = name;
        this.fname = fname;
        this.studentId = studentId;
        this.groupId = groupId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
