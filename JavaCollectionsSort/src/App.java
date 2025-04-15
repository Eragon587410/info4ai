import java.util.*;


public class App {
    public static void main(String[] args) throws Exception {
        Student student1 = new Student(1, "John Doe2", 20);
        Student student2 = new Student(2, "John Doe1", 21);


        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        
        for (Student student : students) {
            System.out.println(student);
        }


        // ordinamento per studentname


        Collections.sort(students);
        




        for (Student student : students) {
            System.out.println(student);
        }


    }
}
