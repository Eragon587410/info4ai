public class App {
    public static void main(String[] args) throws Exception {

        //Student prova = new Student();
        GraduateStudent prova = new GraduateStudent();
        prova.computeCourseGrade();
        System.out.println(prova.getCourseGrade());

        prova.setTestScore(1, 900);
        prova.computeCourseGrade();

        System.out.println(prova.getCourseGrade());


        System.out.println(Student.getNumOfTests());
    }
}
