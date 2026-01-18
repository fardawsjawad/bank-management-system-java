package com.bankapp.presentation.landing_page.flow;

import com.bankapp.exception.service_exceptions.authentication_service.AuthenticationFailedException;
import com.bankapp.model.Role;
import com.bankapp.model.User;
import com.bankapp.presentation.admin_menu.AdminMenu;
import com.bankapp.presentation.input.ConsoleReader;
import com.bankapp.presentation.user_menu.MainMenu;
import com.bankapp.service.*;

public class LoginFlow {

    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final UserAddressService  userAddressService;
    private final EmploymentProfileService employmentProfileService;
    private final AccountService accountService;
    private final TransactionService transactionService;

    public LoginFlow(
            AuthenticationService authenticationService,
            UserService userService,
            UserRoleService userRoleService,
            UserAddressService userAddressService,
            EmploymentProfileService employmentProfileService,
            AccountService accountService,
            TransactionService transactionService
    ) {

        this.authenticationService = authenticationService;
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.userAddressService = userAddressService;
        this.employmentProfileService = employmentProfileService;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    public void loginUser() {
        System.out.print("\nEnter username or email: ");
        String identifier = ConsoleReader.readString();

        System.out.print("Enter your password: ");
        String plainPassword = ConsoleReader.readString();

        try {
            User user = authenticationService.authenticate(identifier, plainPassword);
            if (user.getRole() == Role.ADMIN) {
                AdminMenu adminMenu = new AdminMenu(
                        userService,
                        userRoleService,
                        userAddressService,
                        employmentProfileService,
                        accountService,
                        transactionService
                );

                System.out.println();
                adminMenu.start(user);
            } else if (user.getRole() == Role.USER) {
                MainMenu mainMenu = new MainMenu(
                        employmentProfileService,
                        userAddressService,
                        userRoleService,
                        accountService,
                        transactionService
                );

                System.out.println();
                mainMenu.start(user);
            }
        } catch (AuthenticationFailedException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

}
