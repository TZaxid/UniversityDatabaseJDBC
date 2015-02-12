package pogo;

public class Speciality {
    private int specId;
    private String specCode;
    private String specName;
    private int facultyID;

    public Speciality(int specId, String specCode, String specName, int facultyID) {
        this.specId = specId;
        this.specCode = specCode;
        this.specName = specName;
        this.facultyID = facultyID;
    }

    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
    }

    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }
}
