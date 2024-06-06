import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String name;
    private String phoneNumber;
    private double balance;

    public BankAccount(String accountNumber, String name, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited rupees " + amount);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew rupees " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Your balance is rupees " + balance);
        } else {
            System.out.println("Withdrawal amount must be greater than zero.");
        }
    }

    public void showBalance() {
        System.out.println("Your account balance is: rupees " + balance);
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Online Banking!");
        
        System.out.print("Enter your account number to create an account: ");
        String accountNumber = scanner.nextLine();
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        
        BankAccount account = new BankAccount(accountNumber, name, phoneNumber);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    account.showBalance();
                    break;
                case 4:
                    System.out.println("Account Details:");
                    System.out.println("Account Number: " + account.getAccountNumber());
                    System.out.println("Name: " + account.getName());
                    System.out.println("Phone Number: " + account.getPhoneNumber());
                    System.out.println("Balance: rupees" + account.getBalance());
                    break;
                case 5:
                    System.out.println("Thank you for using Online Banking!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}