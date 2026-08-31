import java.util.*;

class Student {
    private int id;
    private String name;
    private ArrayList<Integer> grades;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public int getId() {   // ✅ Getter for ID
        return id;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.size();
    }

    public int getHighest() {
        return grades.isEmpty() ? 0 : Collections.max(grades);
    }

    public int getLowest() {
        return grades.isEmpty() ? 0 : Collections.min(grades);
    }

    public boolean isPassed() {
        return getAverage() >= 40;   // ✅ Pass check
    }

    public boolean isDistinction() {
        return getAverage() >= 75;   // ✅ Distinction check
    }

    public void displayStudentReport() {
        System.out.println("ID: " + id + ", Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
        System.out.println("Result: " + (isPassed() ? "Pass" : "Fail"));
        if (isDistinction()) {
            System.out.println("🎉 Distinction Achieved!");
        }
        System.out.println("---------------------------");
    }
}

class GradeTracker {
    private ArrayList<Student> students;

    public GradeTracker() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void displayReport() {
        System.out.println("\n===== Student Grade Report =====");
        int passCount = 0, distinctionCount = 0;

        for (Student s : students) {
            s.displayStudentReport();
            if (s.isPassed()) passCount++;
            if (s.isDistinction()) distinctionCount++;
        }

        System.out.println("Total Students: " + students.size());
        System.out.println("Passed: " + passCount);
        System.out.println("Distinction: " + distinctionCount);
        System.out.println("===============================");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeTracker tracker = new GradeTracker();

        while (true) {
            System.out.println("\n--- Student Grade Tracker ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade to Student");
            System.out.println("3. Display Report");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    tracker.addStudent(new Student(id, name));
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    int grade = sc.nextInt();
                    for (Student s : tracker.getStudents()) {
                        if (s.getId() == sid) {
                            s.addGrade(grade);
                            System.out.println("✅ Grade added successfully!");
                            break;
                        }
                    }
                    break;

                case 3:
                    tracker.displayReport();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
