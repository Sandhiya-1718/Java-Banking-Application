package com.bank.app;

import java.util.Scanner;

public class BankApp {
    private static int accCounter = 101;
    private static final Scanner sc = new Scanner(System.in);

    private static void depositAmount(Bank bank) {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter Amount to Deposit: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Account account = findAccount(bank, accNum);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit Successful. New Balance: ₹" + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void withdrawAmount(Bank bank) {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter Amount to Withdraw: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Account account = findAccount(bank, accNum);
        if (account != null) {
            account.withdraw(amount);
            System.out.println("Withdraw Successful. New Balance: ₹" + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void displayBankDetails(Bank bank) {
        bank.displayBankInfo();
        System.out.println("--- Account Details ---");
        for (Account acc : bank.getAccounts()) {
            acc.showAccountType();
            System.out.println("Holder: " + acc.getHolderName());
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Balance: ₹" + acc.getBalance());
            System.out.println("---------------------------");
        }
    }

    private static Account findAccount(Bank bank, String accNum) {
        for (Account acc : bank.getAccounts()) {
            if (acc.getAccountNumber().equals(accNum)) {
                return acc;
            }
        }
        return null;
    }

    private static Bank initializeBank() {
        System.out.print("Enter Bank Type (1. Nationalized, 2. Cooperative): ");
        int bankChoice = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Bank Name: ");
        String bankName = sc.nextLine();
        System.out.print("Enter Branch Name: ");
        String branchName = sc.nextLine();

        if (bankChoice == 1) {
            return new NationalizedBank(bankName, branchName);
        } else if (bankChoice == 2) {
            return new CooperativeBank(bankName, branchName);
        } else {
            System.out.println("Invalid bank type!");
            return null;
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Open Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Display Bank & Accounts");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    private static void openAccount(Bank bank) {
        System.out.print("Enter Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Select Account Type (1. Savings, 2. Current, 3. Loan): ");
        int accType = sc.nextInt();
        sc.nextLine();

        String accNum = "ACC" + accCounter++;
        Account account = null;

        switch (accType) {
            case 1:
                account = new SavingsAccount(accNum, name, amount);
                break;
            case 2:
                account = new CurrentAccount(accNum, name, amount);
                break;
            case 3:
                account = new LoanAccount(accNum, name, amount);
                break;
            default:
                System.out.println("Invalid account type!");
                return;
        }

        bank.openAccount(account);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Java Banking Application");
        Bank bank = initializeBank();

        if (bank == null) return;

        while (true) {
            displayMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    openAccount(bank);
                    break;
                case 2:
                    depositAmount(bank);
                    break;
                case 3:
                    withdrawAmount(bank);
                    break;
                case 4:
                    displayBankDetails(bank);
                    break;
                case 5:
                    System.out.println("Thank you for using the Java Banking App!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
