import java.util.Scanner;

public class Bank2u {
    public static void main(String[] args) {
        Bank banks = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nATM");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawal");
            System.out.println("3. Account Balance");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    banks.deposit(depositAmount);  // Deposit to the bank
                    System.out.println("Deposit accepted!");
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    boolean success = banks.withdraw(withdrawalAmount);  // Withdraw from the bank
                    if (success) {
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;

                case 3:
                    System.out.println("Your Balance: " + banks.checkBalance());  // Check balance
                    break;

                case 0:
                    System.out.println("Thank You");
                    scanner.close();
                    return;

                default:
                    System.out.println("Please choose between the choices.");
            }
        }
    }
}
