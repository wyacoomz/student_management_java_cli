import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        boolean running = true;

        while (running) {
            System.out.println("===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
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

                    Student s = new Student(id, name, age, course);
                    manager.addStudent(s);
                    break;

                case 2:
                    manager.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to view: ");
                    int viewId = sc.nextInt();
                    sc.nextLine();

                    Student found = manager.findStudentById(viewId);
                    if (found != null) {
                        System.out.println("Found: " + found + "\n");
                    } else {
                        System.out.println("Student not found.\n");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new Course: ");
                    String newCourse = sc.nextLine();

                    manager.updateStudent(updateId, newName, newAge, newCourse);
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    manager.deleteStudent(deleteId);
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }

        sc.close();
    }
}

class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
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

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Age: " + age +
                ", Course: " + course;
    }
}


class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully.\n");
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.\n");
            return;
        }

        System.out.println("Student List:");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();
    }

    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public void updateStudent(int id, String name, int age, String course) {
        Student s = findStudentById(id);
        if (s != null) {
            s.setName(name);
            s.setAge(age);
            s.setCourse(course);
            System.out.println("Student updated successfully.\n");
        } else {
            System.out.println("Student not found.\n");
        }
    }

    public void deleteStudent(int id) {
        Student s = findStudentById(id);
        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted successfully.\n");
        } else {
            System.out.println("Student not found.\n");
        }
    }
}
