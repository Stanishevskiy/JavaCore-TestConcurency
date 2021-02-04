package challenges.task1;

public class Main1 {

    public static void main(String[] args) throws InterruptedException {

        final BankAccount generalAccount = new BankAccount("12345-678", 1000);

//        Thread th1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                generalAccount.deposit(300);
//                generalAccount.withdraw(50);
//            }
//        });
//        Thread th2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                generalAccount.deposit(203.75);
//                generalAccount.withdraw(100);
//            }
//        });

        Thread th1 = new Thread() {
            @Override
            public void run() {
                generalAccount.deposit(300);
                generalAccount.withdraw(50);
            }
        };
        Thread th2 = new Thread() {
            @Override
            public void run() {
                generalAccount.deposit(203.75);
                generalAccount.withdraw(100);
            }
        };

        th1.start();
        th2.start();
        th1.join();
        th2.join();

        System.out.println(generalAccount.toString());
    }
}
