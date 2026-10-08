import java.util.Scanner;

class Student {
    // Data members
    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    // Variables to store calculated values
    double totalFee;
    double scholarship;
    double finalFee;

    // Parameterized constructor
    Student(String studentName, int rollNumber, double marks,
            String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Calculate course fee
    double calculateFee() {
        totalFee = courseCredits * 1500;
        return totalFee;
    }

    // Check eligibility
    boolean checkEligibility() {
        return marks >= 50;
    }

    // Calculate scholarship
    double calculateScholarship() {
        if (marks >= 85) {
            scholarship = totalFee * 0.20;
        } else if (marks >= 70) {
            scholarship = totalFee * 0.10;
        } else {
            scholarship = 0;
        }

        return scholarship;
    }

    // Calculate final fee
    double calculateFinalFee() {
        finalFee = totalFee - scholarship;
        return finalFee;
    }

    // Display student and course details
    void displayDetails() {
        System.out.println("\n========== STUDENT COURSE REGISTRATION ==========");
        System.out.println("Student Name     : " + studentName);
        System.out.println("Roll Number      : " + rollNumber);
        System.out.println("Marks            : " + marks);
        System.out.println("Course Name      : " + courseName);
        System.out.println("Course Credits   : " + courseCredits);

        System.out.println("Eligibility      : Eligible");
        System.out.println("Total Fee        : Rs. " + totalFee);
        System.out.println("Scholarship      : Rs. " + scholarship);
        System.out.println("Final Fee        : Rs. " + finalFee);
        System.out.println("=================================================");
    }
}

public class StudentCourseRegistration {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read student details
        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNumber = sc.nextInt();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        sc.nextLine(); // Consume newline

        // Read course details
        System.out.print("Enter Course Name: ");
        String courseName = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = sc.nextInt();

        // Create object using parameterized constructor
        Student student = new Student(
                studentName,
                rollNumber,
                marks,
                courseName,
                courseCredits);

        // Check eligibility before registration
        if (student.checkEligibility()) {

            // Perform calculations using separate methods
            student.calculateFee();
            student.calculateScholarship();
            student.calculateFinalFee();

            // Display all details
            student.displayDetails();

        } else {
            System.out.println("\nStudent is not eligible for course registration.");
            System.out.println("Minimum required marks: 50");
        }

    }
}