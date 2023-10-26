import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        while (true) {
            System.out.println("\nBanking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter Account Holder Name: ");
                    scanner.nextLine(); // Consume newline character
                    String accountHolder = scanner.nextLine();

                    BankAccount account = new BankAccount(accountNumber, accountHolder);
                    accounts.add(account);
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depositAccountNumber = scanner.next();
                    System.out.print("Enter Deposit Amount: $");
                    double depositAmount = scanner.nextDouble();

                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber().equals(depositAccountNumber)) {
                            acc.deposit(depositAmount);
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String withdrawAccountNumber = scanner.next();
                    System.out.print("Enter Withdrawal Amount: $");
                    double withdrawAmount = scanner.nextDouble();

                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber().equals(withdrawAccountNumber)) {
                            acc.withdraw(withdrawAmount);
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String checkBalanceAccountNumber = scanner.next();

                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber().equals(checkBalanceAccountNumber)) {
                            System.out.println("Account Holder: " + acc.getAccountHolder());
                            System.out.println("Account Balance: $" + acc.getBalance());
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
