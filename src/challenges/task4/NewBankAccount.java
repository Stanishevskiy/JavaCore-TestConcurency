package challenges.task4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NewBankAccount {

    private final String accountNumber;
    private double balance;
    private final Lock lock;

    public NewBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public boolean deposit(double amount) {
        if (lock.tryLock()) {
            //-----------If take away try-finally block we get livelock-------------
            try {
                try {
                    // Simulate database access
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance += amount;
                System.out.printf("%s: Deposit %f\n", Thread.currentThread().getName(), amount);
                return true;
            }
            finally {
                lock.unlock();
            }
            //----------------------------------------------------------------------
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (lock.tryLock()) {
            try {
                try {
                    // Simulate database access
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance -= amount;
                System.out.printf("%s: Withdraw %f\n", Thread.currentThread().getName(), amount);
                return true;
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    public boolean transfer(NewBankAccount destinationAccount, double amount) {
        if (withdraw(amount)) {
            if (destinationAccount.deposit(amount)) {
                return true;
            } else {
                // The deposit failed. Refund the money back into the account.
                System.out.printf("%s: Destination account busy. Refunding money\n",
                        Thread.currentThread().getName());
                deposit(amount);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
