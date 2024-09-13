# ATM Machine System

This Repository contains codebase for ATM Machine System which uses **Singleton and State Design Pattern** . 

## Requirements

1. The machine should get details such as Card Number and Pin Number from Bank.
2. The machine should get details such as Account Holder Name, Account Number, Account Balance, Card Details from Bank.
3. The machine should keep some cash as ATM balance for transaction.
4. The machine should validate Card once inserted.
5. The machine should show errors such as insufficient funds in account.
6. The machine should dispense/deposit cash once validated.
7. The machine should eject card once transaction is completed/failed.

## Classes/Interfaces Details

1. The Card class represents a card with properties such as Card Number and Pin Number.
2. The Account class represents a card with properties such as Account Holder Name, Account Number, Account Balance, Card Details.
3. The Bank class manages the Accounts and Card details and provides method to add Account, update Account balance, update Pin and get Account details.
4. The ATMState interface defines the behavior of the ATM machine in different states with functionalities such as insertCard, insertPin, checkAccountBalance, changePin, withdrawMoney, depositMoney, ejectCard. It enables us to implement **State Design Pattern**.
5. The IdleState, CardInsertedState, PinValidatedState, and TransactionCompleteState classes implement the ATMState interface and define the specific behaviors for each state.

6. The ATMSystem class is the class that represents the ATM machine. It follows the **Singleton pattern** to ensure only one instance of the ATM machine exists.
7. The ATMSystem class maintains the ATMMachineCurrentState, Bank detail, Inserted card detail, Authenticated Account detail and provides methods for state transitions.
8. The Main class demonstrates the usage of the ATM machine.
