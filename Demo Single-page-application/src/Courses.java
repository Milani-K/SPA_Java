public class Courses {
    String courseName;
    String grade;
    double gradePoints;
    int credits;

    // Constructor
    public Courses(String courseName, String grade, int credits) {
        this.courseName = courseName;
        this.grade = grade;
        this.credits = credits;
        calculateGradePoints(); // Calculate grade points on initialization
    }

    public void calculateGradePoints() {
        switch (grade) {
            case "A":
                gradePoints = 4.0;
                break;
            case "B":
                gradePoints = 3.0;
                break;
            case "C":
                gradePoints = 2.0;
                break;
            case "D":
                gradePoints = 1.0;
                break;
            case "E":
                gradePoints = 0.0;
                break;
            default:
                gradePoints = 0.0;
                break;
        }
    }

    @Override
    public String toString() {
        return courseName + " " + grade + " (" + credits + " credits)";
    }
}
