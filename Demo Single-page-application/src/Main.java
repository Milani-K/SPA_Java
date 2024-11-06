import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {
    static ArrayList<Student> students;

    // Static initializer to initialize the students ArrayList
    static {
        students = new ArrayList<>();
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("1. Add Student");
                System.out.println("2. Add Course");
                System.out.println("3. Calculate GPA");
                System.out.println("4. Print Transcript");
                System.out.println("51" +
                        ". Exit");
                System.out.print("Choose an option: ");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student ID: ");
                        String studentId = scanner.nextLine();
                        Student student = new Student(name, studentId);
                        students.add(student);
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter student ID: ");
                        studentId = scanner.nextLine();
                        System.out.print("Enter course name: ");
                        String courseName = scanner.nextLine();
                        System.out.print("Enter grade: ");
                        String grade = scanner.nextLine();
                        System.out.print("Enter credits: ");
                        int credits = scanner.nextInt();
                        scanner.nextLine();

                        Courses course = new Courses(courseName, grade, credits);
                        boolean courseAdded = false;
                        for (Student s : students) {
                            if (s.studentId.equals(studentId)) {
                                courseAdded = s.addCourse(course);
                                if (courseAdded) {
                                    System.out.println("Course added successfully.");
                                } else {
                                    System.out.println("Failed to add course.");
                                }
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter student ID: ");
                        studentId = scanner.nextLine();
                        for (Student s : students) {
                            if (s.studentId.equals(studentId)) {
                                s.calculateGPA();
                                System.out.println("GPA calculated.");
                                break;
                            }
                        }
                        break;

                    case 4:
                        System.out.print("Enter student ID: ");
                        studentId = scanner.nextLine();
                        for (Student s : students) {
                            if (s.studentId.equals(studentId)) {
                                s.printTranscript();
                                break;
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Exiting the program.");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");

                }
            }
        }
            catch (InputMismatchException e) { 
                System.out.print("Error: Input Error");
            }
        }
    }