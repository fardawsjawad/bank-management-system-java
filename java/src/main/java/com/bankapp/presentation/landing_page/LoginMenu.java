package com.bankapp.presentation.landing_page;

import com.bankapp.presentation.input.ConsoleReader;
import com.bankapp.presentation.landing_page.flow.ForgotPasswordFlow;
import com.bankapp.presentation.landing_page.flow.LoginFlow;
import com.bankapp.presentation.landing_page.flow.RegistrationFlow;
import com.bankapp.service.*;

public class LoginMenu {

    private final LoginFlow  loginFlow;
    private final RegistrationFlow registrationFlow;
    private final ForgotPasswordFlow forgotPasswordFlow;
    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final UserAddressService userAddressService;
    private final EmploymentProfileService employmentProfileService;
    private final AccountService accountService;
    private final TransactionService transactionService;

    public LoginMenu(
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

        this.loginFlow = new LoginFlow(
                authenticationService,
                userService,
                userRoleService,
                userAddressService,
                employmentProfileService,
                accountService,
                transactionService
        );

        this.registrationFlow = new RegistrationFlow(
                userService,
                userAddressService,
                employmentProfileService
        );

        this.forgotPasswordFlow = new ForgotPasswordFlow(
                userService
        );
    }

    public void displayMenu() {

        while (true) {
            System.out.println("=== Bank Management System ===");
            System.out.println("1. Login");
            System.out.println("2. Register as a new customer");
            System.out.println("3. Forgot password");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int userChoice = ConsoleReader.readInt();

            switch (userChoice) {
                case 1 -> loginFlow.loginUser();
                case 2 -> registrationFlow.registerUser();
                case 3 -> forgotPasswordFlow.resetPassword();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid choice, try again.\n");
            }
        }
    }

}
