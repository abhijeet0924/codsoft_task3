import java.util.Scanner;

// User ke bank account ko represent karne ke liye class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: ₹" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Error: Insufficient balance! Transaction failed.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount!");
            return false;
        }
    }
}

// ATM Machine ke interface aur options ke liye class
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("---- WELCOME TO THE ATM MACHINE ----");

        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your Current Balance: ₹" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depAmount = scanner.nextDouble();
                    account.deposit(depAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withAmount = scanner.nextDouble();
                    account.withdraw(withAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

// Main class jahan se program shuru hoga
public class Main {
    public static void main(String[] args) {
        // Shuruat mein account mein ₹5000 ka balance daal rahe hain
        BankAccount myAccount = new BankAccount(5000.0);
        ATM atm = new ATM(myAccount);
        atm.start();
    }
}
