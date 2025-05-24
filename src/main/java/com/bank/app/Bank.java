package com.bank.app;

import java.util.*;

public abstract class Bank {
    protected String bankName;
    protected String branchName;
    protected List<Account> accounts = new ArrayList<>();
    private static int bankCounter = 0;
    public static final String BANK_CODE_PREFIX = "BANK-";
    private String bankCode;

    public Bank(String bankName, String branchName) {
        this.bankName = bankName;
        this.branchName = branchName;
        this.bankCode = generateBankCode();
    }

    public abstract void openAccount(Account account);
    public abstract void displayBankInfo();

    public String generateBankCode() {
        bankCounter++;
        return BANK_CODE_PREFIX + String.format("%03d", bankCounter);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getBankCode() {
        return bankCode;
    }
}
