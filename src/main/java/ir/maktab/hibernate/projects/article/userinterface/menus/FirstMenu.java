package ir.maktab.hibernate.projects.article.userinterface.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.impl.LoginUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.usermanagement.impl.RegisterUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.LoginUseCase;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.RegisterUseCase;
import ir.maktab.hibernate.projects.article.userinterface.functions.Users;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstMenu extends Menu {

    public FirstMenu() {
        setActions();
    }

    @Override
    public void execute() {

        while (true) {

            displayMenu();
            command = Users.takeCommand(actions);

            if (command.equals(Actions.exit.name())) {
                exit();
            } else if (command.equals(Actions.articles.name())) {
                new ArticleMenu().execute();
            } else if (command.equals(Actions.login.name())) {
                LoginUseCase loginUseCase
                        = new LoginUseCaseImpl();
                loginUseCase.login(Users.takeUsername(), Users.takePassword());
                User loginUser = AuthenticationService.getInstance().getLoginUser();
                if (loginUser != null)
                    new UserMenu().execute();
            } else if (command.equals(Actions.register.name())) {
                RegisterUseCase registerUseCase
                        = new RegisterUseCaseImpl();
                registerUseCase.register(
                        Users.takeUsername(), Users.takeNationalCode()
                        , Users.takeBirthday());
            }
        }
    }

    @Override
    protected void displayMenu() {
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                      First Menu                               |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  articles        ---->    See all of Articles.                |");
        System.out.println("\t|  login           ---->    Login.                              |");
        System.out.println("\t|  register        ---->    Register.                           |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    @Override
    protected void setActions() {
        actions = new ArrayList<>(
                Arrays.asList(
                        Actions.articles.name()
                        , Actions.login.name()
                        , Actions.register.name()
                        , Actions.exit.name()));
    }
}
