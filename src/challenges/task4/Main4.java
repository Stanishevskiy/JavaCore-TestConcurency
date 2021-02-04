package challenges.task4;

public class Main4 {

    public static void main(String[] args) {

        final NewBankAccount account1 = new NewBankAccount("12345-678", 500.00);
        final NewBankAccount account2 = new NewBankAccount("98765-432", 1000.00);

        new Thread(new Transfer(account1, account2, 10.00), "Transfer1").start();
        new Thread(new Transfer(account2, account1, 55.88), "Transfer2").start();
    }
}
