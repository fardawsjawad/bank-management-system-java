package com.bankapp;

import com.bankapp.dao.*;
import com.bankapp.dao.impl.*;
import com.bankapp.model.*;
import com.bankapp.presentation.admin_menu.AdminMenu;
import com.bankapp.presentation.input.GetUserInput;
import com.bankapp.presentation.landing_page.LoginMenu;
import com.bankapp.presentation.landing_page.flow.ForgotPasswordFlow;
import com.bankapp.presentation.user_menu.MainMenu;
import com.bankapp.security.PasswordHasher;
import com.bankapp.service.*;
import com.bankapp.service.impl.*;

import java.time.LocalDate;
import java.util.Optional;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args )
    {



//        AuthenticationService authenticationService = new AuthenticationService();
//        User user = authenticationService.authenticate("USER00001", "StrongPass123");
//        System.out.println(user.getUsername() + " " + user.getRole());

//        UserDAO userDAO = new UserDAOImpl();
//        Optional<User> userOptional = userDAO.getUserForAuthentication("USER0000101");
////        System.out.println(userOptional.get());
//
//        User user = userOptional.get();
//        System.out.println(user.getUsername() + " " + user.getPasswordHash() + " " + user.getRole());

//        User user = GetUserInput.getUser();
//        UserAddress userAddress = GetUserInput.getUserAddress();
//        EmploymentProfile employmentProfile = GetUserInput.getEmploymentProfile();
//
        UserDAO userDAO = new UserDAOImpl();
        UserAddressDAO userAddressDAO = new UserAddressDAOImpl();
        EmploymentProfileDAO employmentProfileDAO = new EmploymentProfileDAOImpl();
        UserRoleDAO userRoleDAO = new UserRoleDAOImpl();
        UserService userService = new UserServiceImpl(userDAO, userAddressDAO, employmentProfileDAO, userRoleDAO);
        UserRoleService userRoleService = new UserRoleServiceImpl(userRoleDAO, userDAO);
        UserAddressService userAddressService = new UserAddressServiceImpl(userAddressDAO, userDAO);
        EmploymentProfileService employmentProfileService = new EmploymentProfileServiceImpl(employmentProfileDAO, userDAO);
        AccountDAO accountDAO = new AccountDAOImpl();
        AccountService accountService = new AccountServiceImpl(accountDAO, userDAO);
        TransactionDAO transactionDAO = new TransactionDAOImpl();
        TransactionService transactionService = new TransactionServiceImpl(transactionDAO, accountDAO);
        AuthenticationService authenticationService = new AuthenticationService();
////

        LoginMenu loginMenu = new LoginMenu(
            authenticationService,
                userService,
                userRoleService,
                userAddressService,
                employmentProfileService,
                accountService,
                transactionService
        );
        loginMenu.displayMenu();

//        AdminMenu adminMenu = new AdminMenu(userService, userRoleService, userAddressService,  employmentProfileService, accountService, transactionService);
//        adminMenu.start();

//        Account account = new Account();
//        account.setTransactionPinHash("567890");
//        account.setAccountOwnerId(8L);
//        account.setAccountType(AccountType.SAVINGS);
//        account.setAccountBalance(BigDecimal.ZERO);
//        account.setBicSwiftCode("IFKNS1111");
//        account.setOverdraftLimit(BigDecimal.ZERO);
//        account.setOpeningDate(LocalDate.now());
//        account.setClosingDate(null);
//        account.setAccountStatus(AccountStatus.ACTIVE);
//        account.setStatusReason(null);
//
//        AccountDAO accountDAO = new AccountDAOImpl();
//        accountDAO.createAccount(account);

//        System.out.println(accountDAO.getAccountById(14L));

//        User user = new User(
//                8L, "USER111112", "Michelle", "Mason",
//                LocalDate.of(2007, 8, 8), Gender.MALE,
//                "ashly@123.com", "Moroccan", "43221",
//                "7382934212"
//        );
//
//        EmploymentProfileDAO empDAO = new EmploymentProfileDAOImpl();
//        UserAddressDAO userAddressDAO = new UserAddressDAOImpl();
//        UserDAO userDAO = new UserDAOImpl();
//        UserRoleDAO userRoleDAO = new UserRoleDAOImpl();
//        EmploymentProfileService employmentProfileService = new EmploymentProfileServiceImpl(empDAO);
//        UserAddressService userAddressService = new UserAddressServiceImpl(userAddressDAO, userDAO);
//        UserRoleService userRoleService = new UserRoleServiceImpl(userRoleDAO, userDAO);
//        AccountDAO accountDAO = new AccountDAOImpl();
//        AccountService accountService = new AccountServiceImpl(accountDAO, userDAO);
//
//        TransactionDAO transactionDAO = new TransactionDAOImpl();
//        TransactionService transactionService = new TransactionServiceImpl(transactionDAO, accountDAO);
//
//        MainMenu mainMenu = new MainMenu(employmentProfileService, userAddressService, userRoleService, accountService, transactionService);
//        mainMenu.start(user);

    }

}