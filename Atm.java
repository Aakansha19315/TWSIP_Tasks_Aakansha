package intern;

import java.util.Scanner;

public class Atm{
    private double balance;

    public Atm() {
        balance = 1000.0; // Initializing default balance
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Transfer");
        System.out.println("5. Exit");
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + balance);
    }

    public void withdrawCash(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void depositCash(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void transferFunds(double amount, Atm targetAccount) {
        if (amount <= balance) {
            balance -= amount;
            targetAccount.depositCash(amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public static void main(String[] args) {
        Atm atm = new Atm();
        Atm anotherAccount = new Atm();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    atm.withdrawCash(amount);
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: ");
                    amount = scanner.nextDouble();
                    atm.depositCash(amount);
                    break;
                case 4:
                    System.out.print("Enter the amount to transfer: ");
                    amount = scanner.nextDouble();
                    atm.transferFunds(amount, anotherAccount);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
