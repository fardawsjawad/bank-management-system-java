package com.bankapp.presentation.user_menu;

import com.bankapp.presentation.user_menu.flow.TransactionFlow;
import com.bankapp.presentation.input.ConsoleReader;
import com.bankapp.service.AccountService;
import com.bankapp.service.TransactionService;
import com.bankapp.util.LogoutUser;

public class TransactionMenu {

    private final TransactionFlow transactionFlow;

    public TransactionMenu(
            TransactionService transactionService,
            AccountService accountService
    ) {
        this.transactionFlow = new TransactionFlow(transactionService, accountService);
    }

    public void display(Long userId) {
        while (true) {
            System.out.println("\n=== Transaction Operations ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer Money");
            System.out.println("4. View Transactions");
            System.out.println("5. View Recent Transactions");
            System.out.println("6. View Transactions by Date");
            System.out.println("7. Return to the previous menu");
            System.out.println("8. Logout");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int userChoice = ConsoleReader.readInt();

            switch (userChoice) {
                case 1: transactionFlow.deposit();
                break;
                case 2: transactionFlow.withdraw();
                break;
                case 3: transactionFlow.transfer();
                break;
                case 4: transactionFlow.viewTransactions(userId);
                break;
                case 5: transactionFlow.viewRecentTransactions(userId);
                break;
                case 6:  transactionFlow.viewTransactionsByDate(userId);
                break;
                case 7: return;
                case 8: LogoutUser.logout();
                break;
                case 0: {
                    System.out.println("Exiting the program. Good bye!");
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}
