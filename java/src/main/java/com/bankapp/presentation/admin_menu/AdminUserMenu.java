package com.bankapp.presentation.admin_menu;

import com.bankapp.model.User;
import com.bankapp.model.UserAddress;
import com.bankapp.presentation.admin_menu.flow.AdminUserFlow;
import com.bankapp.presentation.input.ConsoleReader;
import com.bankapp.presentation.input.GetUserInput;
import com.bankapp.service.EmploymentProfileService;
import com.bankapp.service.UserAddressService;
import com.bankapp.service.UserRoleService;
import com.bankapp.service.UserService;
import com.bankapp.util.LogoutUser;

public class AdminUserMenu {

    private final AdminUserFlow  adminUserFlow;

    public AdminUserMenu(
            UserService userService,
            UserRoleService userRoleService,
            UserAddressService userAddressService,
            EmploymentProfileService employmentProfileService
    ) {

        this.adminUserFlow = new AdminUserFlow(userService, userRoleService, userAddressService, employmentProfileService);
    }

    public void display() {
        while (true) {
            System.out.println("\n=== User Operations ===");
            System.out.println("1. Create a New User");
            System.out.println("2. Fetch User by ID");
            System.out.println("3. Fetch User by Username");
            System.out.println("4. Fetch User by Email");
            System.out.println("5. Update User Details");
            System.out.println("6. Update a User's Username");
            System.out.println("7. Delete a User");
            System.out.println("8. Return to the previous menu");
            System.out.println("9. Logout");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int userChoice = ConsoleReader.readInt();

            switch (userChoice) {
                case 1 -> adminUserFlow.createUser();
                case 2 -> adminUserFlow.displayUserById();
                case 3 -> adminUserFlow.displayUserByUsername();
                case 4 -> adminUserFlow.displayUserByEmail();
                case 5 -> adminUserFlow.updateUser();
                case 6 -> adminUserFlow.updateUsername();
                case 7 ->  adminUserFlow.deleteUser();
                case 8 -> {
                    return;
                }
                case 9 -> LogoutUser.logout();
                case 0 -> {
                    System.out.println("Exiting the program. Good Bye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again!");
            }
        }
    }

}
