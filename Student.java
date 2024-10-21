package pojo;

public class Student {
    String studID;
    String studName;
    String studSub;
    int studMarks;

    public Student() {
        super();
    }
    public Student(String studID, String studName, String studSub, int studMarks) {
        this.studID = studID;
        this.studName = studName;
        this.studSub = studSub;
        this.studMarks = studMarks;
    }

    public String getStudID() {
        return studID;
    }

    public void setStudID(String studID) {
        this.studID = studID;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudSub() {
        return studSub;
    }

    public void setStudSub(String studSub) {
        this.studSub = studSub;
    }

    public int getStudMarks() {
        return studMarks;
    }

    public void setStudMarks(int studMarks) {
        this.studMarks = studMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studID='" + studID + '\'' +
                ", studName='" + studName + '\'' +
                ", studSub='" + studSub + '\'' +
                ", studMarks=" + studMarks +
                '}';
    }
}
