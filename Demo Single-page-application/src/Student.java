import java.util.ArrayList;

public class Student {
    String name;
    String studentId;
    double gpa;
    ArrayList<Courses> courses;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.gpa = 0.0;
        this.courses = new ArrayList<>();
    }

    public boolean addCourse(Courses course) {
        if (courses.size() < 3) {
            courses.add(course);
            calculateGPA();
            return true;
        } else {
            System.out.println("Maximum number of courses reached (3).");
            return false;
        }
    }

    public void calculateGPA() {
        double totalGradePoints = 0;
        int totalCredits = 0;
        for (Courses course : courses) {
            totalGradePoints += course.gradePoints * course.credits;
            totalCredits += course.credits;
        }

        if (totalCredits > 0) {
            gpa = totalGradePoints / totalCredits;
        } else {
            gpa = 0.0;
        }
    }

    public void printTranscript() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + studentId);
        System.out.println("GPA: " + gpa);
        System.out.println("Courses: " + courses.toString());
    }
}

