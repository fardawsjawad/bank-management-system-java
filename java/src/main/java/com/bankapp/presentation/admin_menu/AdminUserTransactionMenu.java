package com.bankapp.presentation.admin_menu;

import com.bankapp.presentation.admin_menu.flow.AdminUserTransactionFlow;
import com.bankapp.presentation.input.ConsoleReader;
import com.bankapp.service.TransactionService;
import com.bankapp.util.LogoutUser;

public class AdminUserTransactionMenu {

    private final AdminUserTransactionFlow adminUserTransactionFlow;

    public AdminUserTransactionMenu(
            TransactionService transactionService
    ) {

        this.adminUserTransactionFlow = new AdminUserTransactionFlow(transactionService);
    }

    public void display() {
        while (true) {
            System.out.println("\n=== User Transaction Operations ===");
            System.out.println("1. Fetch a Transaction by ID");
            System.out.println("2. Fetch Transactions by Account ID");
            System.out.println("3. Fetch an Account's Transactions by Date");
            System.out.println("4. Fetch Recent Transactions for an Account");
            System.out.println("5. Fetch Transactions by Status");
            System.out.println("6. Update a Transaction Status");
            System.out.println("7. Return to the previous menu");
            System.out.println("8. Logout");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int userChoice = ConsoleReader.readInt();

            switch (userChoice) {
                case 1 -> adminUserTransactionFlow.fetchTransactionById();
                case 2 -> adminUserTransactionFlow.fetchTransactionsByAccountId();
                case 3 -> adminUserTransactionFlow.viewTransactionsByDate();
                case 4 -> adminUserTransactionFlow.fetchRecentTransactions();
                case 5 -> adminUserTransactionFlow.fetchTransactionsByStatus();
                case 6 -> adminUserTransactionFlow.updateTransactionStatus();
                case 7 -> {
                    return;
                }
                case 8 -> LogoutUser.logout();
                case 0 -> {
                    System.out.println("Exiting the program. Good Bye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again!");
            }
        }
    }
}
