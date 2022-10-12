package classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Classroom {
    public int capacity;
    public List<Student> students;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<Student>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        if (students.contains(student)) {
            return "Student is already in the classroom";
        }
        if (students.size() >= capacity) {
            return "No seats in the classroom";
        }
        students.add(student);
        return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
    }

    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }
        return "Student not found";
    }

    public String getSubjectInfo(String subject) {
        List<Student> studentsWithSubject = students.stream()
                .filter(s -> s.getBestSubject().equals(subject))
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        if (studentsWithSubject.size() > 0) {
            sb.append(String.format("Subject: %s\nStudents:\n", subject));
            for (Student student : studentsWithSubject) {
                sb.append(String.format("%s %s\n", student.getFirstName(), student.getLastName()));
            }
        } else {
            sb.append("No students enrolled for the subject");
        }
        return sb.toString().trim();
    }

    public Student getStudent(String firstName, String lastName) {
        return students.stream()
                .filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
                .findFirst().orElse(null);
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Classroom size: %d\n", this.getStudentCount()));
        for (Student student : students) {
            sb.append(String.format("==%s\n", student.toString()));
        }
        return sb.toString().trim();
    }
}
