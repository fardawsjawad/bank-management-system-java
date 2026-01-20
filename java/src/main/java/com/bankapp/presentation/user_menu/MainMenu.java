package com.bankapp.presentation.user_menu;

import com.bankapp.model.User;
import com.bankapp.presentation.input.ConsoleReader;
import com.bankapp.service.*;
import com.bankapp.util.LogoutUser;

public class MainMenu {

    private final UserMenu userMenu;
    private final AccountMenu accountMenu;
    private final TransactionMenu transactionMenu;

    public MainMenu(
            EmploymentProfileService employmentProfileService,
            UserAddressService userAddressService,
            UserRoleService userRoleService,
            AccountService accountService,
            TransactionService transactionService) {

        this.userMenu = new UserMenu(employmentProfileService, userAddressService, userRoleService);
        this.accountMenu = new AccountMenu(accountService);
        this.transactionMenu = new TransactionMenu(transactionService, accountService);
    }

    public void start(User user) {
        System.out.println("Welcome "  + user.getFirstName() + " " + user.getLastName() + "!\n");

        while (true) {
            System.out.println("=== Bank Management System ===");
            System.out.println("1. User Operations");
            System.out.println("2. Account Operations");
            System.out.println("3. Transactions");
            System.out.println("4. Logout");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = ConsoleReader.readInt();

            switch (choice) {
                case 1 -> userMenu.display(user);
                case 2 -> accountMenu.display(user);
                case 3 -> transactionMenu.display(user.getUserId());
                case 4 -> LogoutUser.logout();
                case 0 -> {
                    System.out.println("Exiting the program. Good bye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
