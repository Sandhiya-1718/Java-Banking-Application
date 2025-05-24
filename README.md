
# 💳 Java Banking Application (Console-Based)

A simple console-based banking system in Java that demonstrates key Object-Oriented Programming (OOP) principles including abstraction, inheritance, interfaces, polymorphism, constructors, and modifiers like `static` and `final`.

---

## 📌 Features

- Create accounts in **Nationalized** or **Cooperative** banks.
- Support for **Savings**, **Current**, and **Loan** account types.
- Perform core banking operations:
  - Open Account
  - Deposit Amount
  - Withdraw Amount
  - Display Bank and Account Details
- Console-based user interaction (no GUI).
- Unique account number generation using static counter.
- Demonstrates Java OOP principles in action.

---

## 🛠 Technologies Used

- **Java 8+**
- **IntelliJ IDEA (Community Edition)**
- **No external libraries**

---

## 🧱 Project Structure

```
src/
├── BankApp.java                # Main class with the menu and user interaction
├── Bank.java                   # Abstract class for common bank structure
├── NationalizedBank.java       # Child of Bank (Nationalized)
├── CooperativeBank.java        # Child of Bank (Cooperative)
├── Account.java                # Abstract class for accounts
├── SavingsAccount.java         # Implements AccountOperations
├── CurrentAccount.java         # Implements AccountOperations
├── LoanAccount.java            # Implements AccountOperations
└── AccountOperations.java      # Interface for deposit/withdraw operations
```

---

## 🚀 How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/java-banking-app.git
   ```

2. Open the project in **IntelliJ IDEA**.

3. Make sure Java SDK 1.8+ is configured.

4. Run the `BankApp.java` file.

---

## 📖 Sample Interaction

```
🏦 Welcome to Java Banking Application
Enter Bank Type (1. Nationalized, 2. Cooperative): 1
Enter Bank Name: SBI
Enter Branch Name: CG

📋 Menu:
1. Open Account
2. Deposit
3. Withdraw
4. Display Bank & Accounts
5. Exit

Enter choice: 1
Enter Holder Name: Rahul
Enter Initial Deposit: 8500
Select Account Type (1. Savings, 2. Current, 3. Loan): 1

✅ Account Opened Successfully!

📋 Menu:
4
--- Bank Details ---
Bank Name: SBI
Branch: CG
Bank Code: BANK-001
--- Account Details ---
Account Type: Savings Account
Holder: Rahul
Account Number: ACC101
Balance: ₹8500.0
```

---

## 🎯 OOP Concepts Used

| Concept           | Where It's Used                                |
|-------------------|-------------------------------------------------|
| **Abstract Class** | `Bank`, `Account`                              |
| **Inheritance**   | `NationalizedBank`, `CooperativeBank`          |
| **Interface**     | `AccountOperations`                             |
| **Polymorphism**  | Accounts handled via `Account` reference        |
| **Constructors**  | All classes use parameterized constructors      |
| **Static**        | Account counter, bank code generation           |
| **Final**         | Constant bank code prefix (`BANK-`)            |

