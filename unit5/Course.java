package unit5;

public class Course {
    private String courseName;
    private String grade;

    public Course(String courseName) {
        this.courseName = courseName;
        this.grade = "F";
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return courseName + " (Grade: " + grade + ")";
    }
}
