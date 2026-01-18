package com.bankapp.presentation.user_menu;

import com.bankapp.model.User;
import com.bankapp.presentation.user_menu.flow.UserFlow;
import com.bankapp.presentation.input.ConsoleReader;
import com.bankapp.service.EmploymentProfileService;
import com.bankapp.service.UserAddressService;
import com.bankapp.service.UserRoleService;
import com.bankapp.util.LogoutUser;

public class UserMenu {

    private final UserFlow  userFlow;

    public UserMenu(
            EmploymentProfileService employmentProfileService,
            UserAddressService userAddressService,
            UserRoleService userRoleService) {

        this.userFlow = new UserFlow(employmentProfileService, userAddressService, userRoleService);
    }

    public void display(User user) {
        while (true) {
            System.out.println("\n=== User Operations ===");
            System.out.println("1. View Profile");
            System.out.println("2. Update Address");
            System.out.println("3. Update EmploymentProfile");
            System.out.println("4. Return to the previous menu");
            System.out.println("5. Logout");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int userChoice = ConsoleReader.readInt();

            switch (userChoice) {
                case 1: userFlow.viewProfile(user);
                break;
                case 2: userFlow.updateAddress(user.getUserId());
                break;
                case 3: userFlow.updateEmploymentProfile(user.getUserId());
                break;
                case 4: return;
                case 5: LogoutUser.logout();
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
