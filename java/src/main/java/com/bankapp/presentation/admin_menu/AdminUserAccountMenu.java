package com.bankapp.presentation.admin_menu;

import com.bankapp.presentation.admin_menu.flow.AdminUserAccountFlow;
import com.bankapp.presentation.input.ConsoleReader;
import com.bankapp.service.AccountService;
import com.bankapp.service.UserService;
import com.bankapp.util.LogoutUser;

public class AdminUserAccountMenu {

    private final AdminUserAccountFlow  adminUserAccountFlow;

    public AdminUserAccountMenu(
            UserService userService,
            AccountService accountService
    ) {

        this.adminUserAccountFlow = new AdminUserAccountFlow(userService, accountService);
    }

    public void display() {
        while (true) {
            System.out.println("\n=== User Account Operations ===");
            System.out.println("1. Create an Account for a User");
            System.out.println("2. Fetch All Accounts in the System");
            System.out.println("3. Fetch Account by Account ID");
            System.out.println("4. Fetch Account by Account Number");
            System.out.println("5. Fetch Accounts by User ID");
            System.out.println("6. Update an Account's Type");
            System.out.println("7. Update an Account's Balance");
            System.out.println("8. Update an Account's Status");
            System.out.println("9. Delete an Account");
            System.out.println("10. Return to the previous menu");
            System.out.println("11. Logout");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int userChoice = ConsoleReader.readInt();

            switch (userChoice) {
                case 1 -> adminUserAccountFlow.createAccount();
                case 2 -> adminUserAccountFlow.viewAllAccounts();
                case 3 -> adminUserAccountFlow.fetchAccountById();
                case 4 -> adminUserAccountFlow.fetchAccountByAccountNumber();
                case 5 -> adminUserAccountFlow.fetchAccountsByUserId();
                case 6 -> adminUserAccountFlow.updateAccountType();
                case 7 -> adminUserAccountFlow.updateAccountBalance();
                case 8 ->  adminUserAccountFlow.updateAccountStatus();
                case 9 -> adminUserAccountFlow.deleteAccount();
                case 10 -> {
                    return;
                }
                case 11 -> LogoutUser.logout();
                case 0 -> {
                    System.out.println("Exiting the program. Good Bye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again!");
            }
        }
    }

}
