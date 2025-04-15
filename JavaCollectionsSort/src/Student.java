public class Student implements Comparable<Student> {
    private String studentname;
    private int rollno;
    private int studentage;


    public Student(int rollno, String studentname, int studentage) {
         this.rollno = rollno;
         this.studentname = studentname;
         this.studentage = studentage;
    }


    public String getStudentname() {
         return studentname;
    }
    public void setStudentname(String studentname) {
    this.studentname = studentname;
    }
    public int getRollno() {
    return rollno;
    }
    public void setRollno(int rollno) {
    this.rollno = rollno;
    }
    public int getStudentage() {
    return studentage;
    }
    public void setStudentage(int studentage) {
    this.studentage = studentage;
    }  


    public String toString() {
        return "Student [rollno=" + rollno + ", studentname=" + studentname + ", studentage=" + studentage + "]";
    }


    public int compareTo(Student student) { // 0: this and student are equal, <0: this < student, >0: this > student
        return this.studentname.compareTo(student.getStudentname());
        //return this.studentage - student.getStudentage();
        //return this.rollno - student.getRollno();
        //return student.getRollno() - this.rollno; per fare ordinamento inverso
    }
}
