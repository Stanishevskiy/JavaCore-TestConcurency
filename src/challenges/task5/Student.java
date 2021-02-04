package challenges.task5;

public class Student {

    private Tutor tutor;

    public Student(Tutor tutor) {
        this.tutor = tutor;
    }

    //-----------If method set synchronized - we get deadlock-----------
    public void startStudy() {
        // study
        System.out.println("Student is studying");
    }

    public synchronized void handInAssignment() {
        tutor.getProgressReport();
        System.out.println("Student handed in assignment");
    }
}
