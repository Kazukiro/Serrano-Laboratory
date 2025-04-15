import java.util.Scanner;

class Person {
    private String name;
    private int id;
 
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
 
    public String getName() {
        return this.name;
    }
   
    public int getID() {
        return this.id;
    }
 
    public void displayInfo() {
        System.out.println("Your name: " + name);
        System.out.println("Your ID: " + id);
    }
}

public class SchoolTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Welcome to National University");
 
        while (running) {
            System.out.println("\nSelect your Identification");
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Staff");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
 
            if (choice == 1) {
                System.out.println("Student's Identification");
                System.out.print("Student name: ");
                String studentName = scanner.nextLine();
                System.out.print("ID number: ");
                int studentId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Current grade level: ");
                String studentGradeLevel = scanner.nextLine();
 
                Student student = new Student(studentName, studentId, studentGradeLevel);
                System.out.println("\nStudent Identification");
                student.displayInfo();
            } else if (choice == 2) {
                System.out.println("Teacher's Identification");
                System.out.print("Teacher name: ");
                String teacherName = scanner.nextLine();
                System.out.print("ID number: ");
                int teacherId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Current teaching Subject: ");
                String teacherSubject = scanner.nextLine();
 
                Teacher teacher = new Teacher(teacherName, teacherId, teacherSubject);
                System.out.println("\nTeacher Identification");
                teacher.displayInfo();
            } else if (choice == 3) {
                System.out.println("Staff's Identification");
                System.out.print("Staff name: ");
                String staffName = scanner.nextLine();
                System.out.print("ID number: ");
                int staffId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Department Staff of: ");
                String staffDepartment = scanner.nextLine();
 
                Staff staff = new Staff(staffName, staffId, staffDepartment);
                System.out.println("\nStaff Identification");
                staff.displayInfo();
            } else if (choice == 4) {
                System.out.println("Thank you for using our Service. God bless you!");
                running = false;
            } else {
                System.out.println("Invalid choice. Please enter either of the following. Thank you");
            }
        }
        scanner.close();
    }
}