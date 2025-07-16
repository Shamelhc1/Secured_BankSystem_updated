# 💳 Bank System in Java

A simple yet well-structured banking system implemented in Java, designed with **object-oriented principles**, **encapsulation**, and extensibility in mind.

This project simulates a basic bank environment, handling customers, bank accounts, and transaction operations such as deposits, withdrawals, and transaction history tracking. It is aimed at demonstrating a solid understanding of OOP design, collections, and clean class separation in Java.

---

UML Class digram:
https://github.com/Shamelhc1/Secured_BankSystem_updated/blob/master/BankSystem_ULM.png

- The Bank Account Class is an inner class of the Bank Class.


## 📦 Features Implemented

- **Encapsulated Object Model**:
  - `Bank`: Central class to manage customers and orchestrate transactions.
  - `BankCustomer`: Represents a customer, their identity, and accounts.
  - `Transaction`: Represents a record of financial operations.

- **Core Banking Operations**:
  - Deposit and withdraw funds.
  - Store and retrieve transaction history per account.
  - Defensive copying of internal lists to protect data integrity.

- **Encapsulation Enhancements**:
  - Constructors restricted to package-private for better object control.
  - Transactions can only be created and processed through the `Bank` class, not directly from a customer.
  - `getAccountList()` returns defensive copies to preserve internal state.

- **Clear Commit History**:
  - Tracked and documented evolution of encapsulation, defensive coding, and class responsibility separation using Git.

---

## 🧠 Object-Oriented Design Focus

- Strong adherence to **OOP principles**: Abstraction, Encapsulation, Separation of Concerns.
- Clean class responsibilities and interactions.
- Logical and maintainable structure ideal for  intermediate projects.

---

## 🚧 Room for Improvement

To elevate this from a solid project to a more advanced one, consider:

### 💾 1. Persistent Data Storage
- Implement saving/loading of customers and transactions to a file (JSON/CSV) or lightweight database (like SQLite).

### 🔐 2. Thread Safety
- Use `synchronized` methods or locks (e.g., `ReentrantLock`) to protect shared mutable data (like balances) for multi-threaded environments.

### 🔁 3. Error Handling
- Improve robustness by adding exception handling for invalid inputs, overdraw attempts, and null references.

---
