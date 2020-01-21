package ir.maktab.hibernate.projects.article.userinterface.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.features.usermanagement.impl.LogoutUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.LogoutUseCase;
import ir.maktab.hibernate.projects.article.userinterface.functions.Users;

import java.util.ArrayList;
import java.util.Arrays;

public class UserMenu extends Menu {

    public UserMenu() {
        setActions();
    }

    @Override
    public void execute() {
        command = "";

        while (!command.equals(Actions.logout.name())) {
            displayMenu();
            command = Users.takeCommand(actions);

            if (command.equals(Actions.exit.name())) {
                exit();
            } else if (command.equals(Actions.myarticles.name())) {
                new UserArticleMenu().execute();
            } else if (command.equals(Actions.articles.name())) {
                new ArticleMenu().execute();
            } else if (command.equals(Actions.profile.name())) {
                new ProfileMenu().execute();
            } else if (command.equals(Actions.logout.name())) {
                LogoutUseCase logoutUseCase = new LogoutUseCaseImpl();
                logoutUseCase.logout();
            }
        }
    }

    @Override
    protected void displayMenu() {
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                      User Menu                                |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  myarticles      ---->    Your Articles.                      |");
        System.out.println("\t|  articles        ---->    See all of Articles.                |");
        System.out.println("\t|  profile         ---->    See your Profile.                   |");
        System.out.println("\t|  logout          ---->    Logout.                             |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    @Override
    protected void setActions() {
        actions = new ArrayList<>(
                Arrays.asList(
                        Actions.myarticles.name()
                        , Actions.articles.name()
                        , Actions.profile.name()
                        , Actions.logout.name()
                        , Actions.exit.name()));
    }
}
