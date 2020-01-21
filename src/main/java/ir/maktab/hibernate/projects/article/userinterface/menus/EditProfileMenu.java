package ir.maktab.hibernate.projects.article.userinterface.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.impl.ChangeBirthdayUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.usermanagement.impl.ChangeNationalCodeUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.usermanagement.impl.ChangePasswordUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.usermanagement.impl.ChangeUsernameUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.ChangeBirthdayUseCase;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.ChangeNationalCodeUseCase;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.ChangePasswordUseCase;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.ChangeUsernameUseCase;
import ir.maktab.hibernate.projects.article.userinterface.functions.Users;

import java.util.ArrayList;
import java.util.Arrays;

public class EditProfileMenu extends Menu {
    public EditProfileMenu() {
        setActions();
    }

    @Override
    public void execute() {
        command = "";

        while (!command.equals(Actions.back.name())) {
            displayMenu();
            command = Users.takeCommand(actions);

            if (command.equals(Actions.exit.name())) {
                exit();
            }

            User loginUser = AuthenticationService.getInstance().getLoginUser();

            if (command.equals(Actions.username.name())) {
                ChangeUsernameUseCase changeUsernameUseCase
                        = new ChangeUsernameUseCaseImpl();
                loginUser = changeUsernameUseCase
                        .change(loginUser, Users.takeNewUsername());
            } else if (command.equals(Actions.nationcode.name())) {
                ChangeNationalCodeUseCase changeNationalCodeUseCase
                        = new ChangeNationalCodeUseCaseImpl();
                loginUser = changeNationalCodeUseCase
                        .change(loginUser, Users.takeNewNationalCode());
            } else if (command.equals(Actions.birhday.name())) {
                ChangeBirthdayUseCase changeBirthdayUseCase
                        = new ChangeBirthdayUseCaseImpl();
                loginUser = changeBirthdayUseCase
                        .change(loginUser, Users.takeNewBirthday());
            } else if (command.equals(Actions.password.name())) {
                ChangePasswordUseCase changePasswordUseCase
                        = new ChangePasswordUseCaseImpl();
                loginUser = changePasswordUseCase
                        .change(loginUser, Users.takeNewPassword());
            }
            if (loginUser != null)
                AuthenticationService.getInstance().setLoginUser(loginUser);
        }
    }

    @Override
    protected void displayMenu() {
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                       Edit Profile Menu                       |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  username        ---->    Edit Username.                      |");
        System.out.println("\t|  nationcode      ---->    Edit National Code .                |");
        System.out.println("\t|  birthday        ---->    Edit Birthday.                      |");
        System.out.println("\t|  password        ---->    Edit Password.                      |");
        System.out.println("\t|  back            ---->    Back to Profile Menu.               |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    @Override
    protected void setActions() {
        actions = new ArrayList<>(
                Arrays.asList(
                        Actions.username.name()
                        , Actions.nationcode.name()
                        , Actions.birhday.name()
                        , Actions.password.name()
                        , Actions.back.name()
                        , Actions.exit.name()));
    }
}
