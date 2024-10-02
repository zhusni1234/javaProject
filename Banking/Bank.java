public class Bank {
    private double balance;

    public Bank() {
        this.balance = 1000.0; // Initial balance
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false; // Insufficient funds
    }

    public double checkBalance() {
        return balance;
    }
}
