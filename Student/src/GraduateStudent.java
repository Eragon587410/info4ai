public class GraduateStudent extends Student {


    public GraduateStudent(){
        super();
    }

    public GraduateStudent(String name){
        super(name);
    }

    

    @Override
    public void computeCourseGrade() {
        int total = 0;
        for (int i = 0; i < getNumOfTests(); i++) {
            total += getTestScore(i+1);
        }
        if (total / getNumOfTests() >= 80) {
            setCourseGrade("Pass");
        } else {
            setCourseGrade("No Pass");
        }
    }
}
