package challenges.task6;

public class NewTutor {

    private NewStudent student;

    public synchronized void setStudent(NewStudent student) {
        this.student = student;
    }

    public void studyTime() {
        synchronized (this) {
            System.out.println("Tutor has arrived");
            synchronized (student) {
                try {
                    // wait for student to arrive and hand in assignment
                    this.wait();
                } catch (InterruptedException e) {
                    // go through
                }
                student.startStudy();
                System.out.println("Tutor is studying with student");
            }
        }
    }

    public synchronized void getProgressReport() {
        // get progress report
        System.out.println("Tutor gave progress report");
    }
}
