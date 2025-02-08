import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}

class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(int id, String name, int age) {
        students.add(new Student(id, name, age));
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        System.out.println("Student removed successfully.");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StudentManager manager = new StudentManager();
            
            while (true) {
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("3. Display Students");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Age: ");
                        int age = scanner.nextInt();
                        manager.addStudent(id, name, age);
                        break;
                    case 2:
                        System.out.print("Enter ID to remove: ");
                        int removeId = scanner.nextInt();
                        manager.removeStudent(removeId);
                        break;
                    case 3:
                        manager.displayStudents();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }
    }
}
