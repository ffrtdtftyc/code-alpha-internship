import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    int getHighest() {
        int max = Integer.MIN_VALUE;
        for (int grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        return max;
    }

    int getLowest() {
        int min = Integer.MAX_VALUE;
        for (int grade : grades) {
            if (grade < min) {
                min = grade;
            }
        }
        return min;
    }

    void displayReport() {
        System.out.println("Student: " + name);
        System.out.println("Grades: " + grades);
        System.out.printf("Average: %.2f\n", getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
        System.out.println("---------------------------");
    }
}

public class studentgradetracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int studentCount = Integer.parseInt(scanner.nextLine()); // fix: read full line

        for (int i = 0; i < studentCount; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            Student student = new Student(name);

            System.out.print("Enter number of grades for " + name + ": ");
            int gradeCount = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < gradeCount; j++) {
                System.out.print("Enter grade #" + (j + 1) + ": ");
                int grade = Integer.parseInt(scanner.nextLine());
                student.addGrade(grade);
            }

            students.add(student);
        }

        System.out.println("\n====== Summary Report ======");
        for (Student s : students) {
            s.displayReport();
        }

        scanner.close();
    }
}
