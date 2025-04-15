abstract public class Student{
    private static final int NUM_OF_TESTS = 3;
    private String name;
    private int[] test;
    private String courseGrade;

    public Student(){
        test = new int[NUM_OF_TESTS];
        courseGrade = "*****";
    }

    public Student(String name){
        this();
        setName(name);
    }

    public Student(String name, int[]test, String courseGrade){
        this();
        setName(name);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }

    public String getCourseGrade() {
        return courseGrade;
    }

    public int getTestScore(int n){
        return test[n-1];
    }

    public void setTestScore(int n, int p){
        if (n > 0 && n <= test.length && p >= 0){
            test[n-1] = p;
        }
        
    }

    public static int getNumOfTests() {
        return NUM_OF_TESTS;
    }

    abstract public void computeCourseGrade();

}