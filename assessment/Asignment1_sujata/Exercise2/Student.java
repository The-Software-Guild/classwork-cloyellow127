package Exercise2;

// Exercise 2 : Create a class called Student with the following details: RollNo, StudName, MarksInEng, 
// MarksInMaths and MarksInScience. Write getters and setters for the all variables. 
//  Create a class called Standard with 8 students’ details and write separate method for each of the following tasks and invoke the same.
// 1.	To display the entire roll no and the name of the students in the class in the ascending order of roll no.
// 2.	To display the roll no and the name of the student who has got the highest percentage.
// 3.	To display the roll no and the name of the student who scored highest mark 
// In mathematics.

public class Student {
    private int rollNo;
    private String studName;
    private float marksInEng;
    private float marksInMaths;
    private float marksInScience;

    public Student(int rollNo, String studName, float marksInEng, float marksInMaths, float marksInScience) {
        this.rollNo = rollNo;
        this.studName = studName;
        this.marksInEng = marksInEng;
        this.marksInMaths = marksInMaths;
        this.marksInScience = marksInScience;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public float getMarksInEng() {
        return marksInEng;
    }

    public void setMarksInEng(float marksInEng) {
        this.marksInEng = marksInEng;
    }

    public float getMarksInMaths() {
        return marksInMaths;
    }

    public void setMarksInMaths(float marksInMaths) {
        this.marksInMaths = marksInMaths;
    }

    public float getMarksInScience() {
        return marksInScience;
    }

    public void setMarksInScience(float marksInScience) {
        this.marksInScience = marksInScience;
    }
}
