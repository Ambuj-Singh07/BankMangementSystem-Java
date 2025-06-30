import java.util.ArrayList;
import java.util.Scanner;

// Account class definition
class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactions;

    public Account(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        transactions.add("Account created for " + accountHolder);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        balance += amount;
        transactions.add("Deposited: ₹" + amount);
        System.out.println("Deposited ₹" + amount + " successfully.");
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            transactions.add("Failed Withdrawal Attempt: ₹" + amount);
        } else {
            balance -= amount;
            transactions.add("Withdrawn: ₹" + amount);
            System.out.println("Withdrawn ₹" + amount + " successfully.");
        }
    }

    // Show current balance
    public void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Print transaction history
    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String t : transactions) {
            System.out.println("- " + t);
        }
    }
}

// Main class with menu
public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        Account account = new Account(name);

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmt = scanner.nextDouble();
                    account.deposit(depositAmt);
                    break;
                case 2:
                    System.out.print("Enter withdraw amount: ₹");
                    double withdrawAmt = scanner.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;
                case 3:
                    account.showBalance();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you! Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
