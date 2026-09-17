import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Average Marks");
            System.out.println("7. Top Student");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                addStudent();
            }

            else if (choice == 2) {
                viewStudents();
            }

            else if (choice == 3) {
                searchStudent();
            }

            else if (choice == 4) {
                updateStudent();
            }

            else if (choice == 5) {
                deleteStudent();
            }

            else if (choice == 6) {
                averageMarks();
            }

            else if (choice == 7) {
                topStudent();
            }

            else if (choice == 8) {
                System.out.println("Program ended.");
                break;
            }

            else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }


    // ADD STUDENT
    static void addStudent() {

        System.out.println("\n--- ADD STUDENT ---");

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(id, name, age, course, marks);

        students.add(s);

        System.out.println("Student added successfully!");
    }


    // VIEW STUDENTS
    static void viewStudents() {

        System.out.println("\n--- ALL STUDENTS ---");

        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("Total Students: " + students.size());

        for (int i = 0; i < students.size(); i++) {

            Student s = students.get(i);

            System.out.println("\nStudent " + (i + 1));
            System.out.println("ID     : " + s.id);
            System.out.println("Name   : " + s.name);
            System.out.println("Age    : " + s.age);
            System.out.println("Course : " + s.course);
            System.out.println("Marks  : " + s.marks);
        }
    }


    // SEARCH
    static void searchStudent() {

        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.id == id) {

                System.out.println("\nStudent Found!");
                System.out.println("ID     : " + s.id);
                System.out.println("Name   : " + s.name);
                System.out.println("Age    : " + s.age);
                System.out.println("Course : " + s.course);
                System.out.println("Marks  : " + s.marks);

                return;
            }
        }

        System.out.println("Student not found!");
    }


    // UPDATE
    static void updateStudent() {

        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.id == id) {

                sc.nextLine();

                System.out.print("Enter new Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter new Age: ");
                s.age = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter new Course: ");
                s.course = sc.nextLine();

                System.out.print("Enter new Marks: ");
                s.marks = sc.nextDouble();

                System.out.println("Student updated successfully!");

                return;
            }
        }

        System.out.println("Student not found!");
    }


    // DELETE
    static void deleteStudent() {

        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).id == id) {

                students.remove(i);

                System.out.println("Student deleted successfully!");

                return;
            }
        }

        System.out.println("Student not found!");
    }


    // AVERAGE
    static void averageMarks() {

        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        double total = 0;

        for (Student s : students) {
            total += s.marks;
        }

        double average = total / students.size();

        System.out.println("Average Marks = " + average);
    }


    // TOP STUDENT
    static void topStudent() {

        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        Student top = students.get(0);

        for (Student s : students) {

            if (s.marks > top.marks) {
                top = s;
            }
        }

        System.out.println("\n--- TOP STUDENT ---");
        System.out.println("ID     : " + top.id);
        System.out.println("Name   : " + top.name);
        System.out.println("Age    : " + top.age);
        System.out.println("Course : " + top.course);
        System.out.println("Marks  : " + top.marks);
    }
}


// STUDENT CLASS
class Student {

    int id;
    String name;
    int age;
    String course;
    double marks;

    Student(int id, String name, int age, String course, double marks) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }
}