
#  Bank Management System (ATM Simulation)

A desktop-based Bank Management System developed using **Java (Swing + AWT)** and **MySQL**.
This project simulates basic ATM functionalities such as account creation, login, deposit, withdrawal, PIN change, and mini statement generation.

---

##  Features

*  User Authentication (Card Number + PIN)
*  Multi-step Account Registration
*  Deposit Money
*  Withdraw Money (with balance validation)
*  Balance Enquiry
*  Mini Statement (Last Transactions + Transaction ID)
*  PIN Change
*  Transaction History Stored in Database

---

##  OOP Concepts Used

* **Abstraction**
  UI interacts with methods without knowing internal SQL logic.

* **Inheritance**
  `BaseService` class is extended by all service classes to reuse database connection logic.

* **Modularity**
  Different functionalities are divided into separate classes:

  * Login
  * Signup
  * Deposit
  * Withdraw
  * MiniStatement
  * BalanceEnquiry

---

##  Project Structure

```
bankmanagementsystem/
│
├── Login.java
├── SignupOne.java
├── SignupTwo.java
├── SignupThree.java
│
├── Transactions.java
├── Deposit.java
├── withdrawl.java
├── BalanceEnquiry.java
├── MiniStatement.java
├── PinChange.java
│
├── Conn.java
│
└── icons/
```

---

##  Database Schema

### customer table

Stores user details and login credentials.

### bank table

Stores transaction history:

* `id` (Primary Key)
* `cardno`
* `date`
* `type` (Deposit / Withdraw)
* `amount`

---

##  Technologies Used

* Java (Swing & AWT)
* MySQL
* JDBC
* OOP Principles

---

##  How to Run

1. Clone the repository:

   ```
   git clone https://github.com/siddheshmane18/Bank_ATM_Simulation.git
   ```

2. Open the project in any Java IDE (IntelliJ / Eclipse / NetBeans)

3. Setup MySQL:

   * Create database: `BankManagementSystem`
   * Import tables (customer, bank)

4. Update database credentials in `Conn.java`

5. Run:

   ```
   Login.java
   ```

---

##  Default Flow

1. Click **Sign Up**
2. Fill all 3 pages
3. Get Card Number & PIN
4. Login using credentials
5. Perform transactions

---

##  Screenshots
<img width="979" height="591" alt="image" src="https://github.com/user-attachments/assets/e32d178a-77c0-4ff3-a2fd-90cadad394d2" />
<img width="1123" height="1008" alt="image" src="https://github.com/user-attachments/assets/abfa9c7f-7409-429a-92d0-90dfee542b5f" />
<img width="1125" height="1004" alt="image" src="https://github.com/user-attachments/assets/6860fb51-1788-4bc0-a32f-1b57ce4ec90b" />
<img width="480" height="738" alt="image" src="https://github.com/user-attachments/assets/aa0ec09c-648f-479c-bd00-f291b5f42d21" />
<img width="1123" height="1010" alt="image" src="https://github.com/user-attachments/assets/69382ae7-c07a-480e-b332-8ec9e3a4fdd4" />
<img width="1127" height="1004" alt="image" src="https://github.com/user-attachments/assets/803b8289-8c25-46aa-87ab-656822441d53" />

---

##  Future Improvements

* Add secure password hashing
* Add transaction limits
* Add admin dashboard
* Convert to web application
* Implement full polymorphism with transaction hierarchy

---

##  Author

Siddhesh Mane

---

##  Guide

Dr. Vijaykumar Mantri

---

##  Notes

This project is created for learning purposes and demonstrates core concepts of Java GUI, JDBC, and Object-Oriented Programming.
