package challenges.task4;

public class Transfer implements Runnable {

    private final NewBankAccount sourceAccount;
    private final NewBankAccount destinationAccount;
    private final double amount;

    public Transfer(NewBankAccount sourceAccount, NewBankAccount destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        while (!sourceAccount.transfer(destinationAccount, amount)) {
            continue;
        }
        System.out.printf("%s completed\n", Thread.currentThread().getName());
    }
}
