package com.bankapp.presentation.user_menu;

import com.bankapp.model.User;
import com.bankapp.presentation.user_menu.flow.AccountFlow;
import com.bankapp.presentation.input.ConsoleReader;
import com.bankapp.service.AccountService;
import com.bankapp.util.LogoutUser;

public class AccountMenu {

    private final AccountFlow accountFlow;

    public AccountMenu(AccountService accountService) {
        this.accountFlow = new AccountFlow(accountService);
    }

    public void display(User user) {
        while(true) {
            System.out.println("\n=== Account Operations ===");
            System.out.println("1. Open Account");
            System.out.println("2. Close Account");
            System.out.println("3. View Account Details");
            System.out.println("4. Return to the previous menu");
            System.out.println("5. Logout");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int userChoice = ConsoleReader.readInt();

            switch (userChoice) {
                case 1: accountFlow.openAccount(user);
                break;
                case 2: accountFlow.closeAccount(user.getUserId());
                break;
                case 3: accountFlow.viewAccountDetails(user.getUserId());
                break;
                case 4:
                    return;
                case 5:  LogoutUser.logout();
                break;
                case 0: {
                    System.out.println("Exiting the program. Good bye!");
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }

}
