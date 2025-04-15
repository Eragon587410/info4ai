public class UnderGraduateStudent extends Student{


    public UnderGraduateStudent(){
        super();
    }

    public UnderGraduateStudent(String name){
        super(name);
    }


    @Override
    public void computeCourseGrade() {
        int total = 0;
        for (int i = 0; i < getNumOfTests(); i++) {
            total += getTestScore(i+1);
        }
        if (total / getNumOfTests() >= 70) {
            setCourseGrade("Pass");
        } else {
            setCourseGrade("No Pass");
        }
    }
}
