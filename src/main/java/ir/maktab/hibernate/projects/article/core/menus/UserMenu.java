package ir.maktab.hibernate.projects.article.core.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.core.takefromuser.TakeCommand;
import ir.maktab.hibernate.projects.article.features.usermanagement.impl.LogoutUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.LogoutUseCase;

public class UserMenu implements Menu {
    @Override
    public void execute() {

        String command = "";

        while (!command.equals(Actions.logout.name())) {
            command = TakeCommand.takeUserCommand();

            if (command.equals(Actions.exit.name())) {
                System.out.println("\n bye bye!");
                System.exit(0);
            }

            else if (command.equals(Actions.articles.name())) {
                new ArticleMenu().execute();
            }

            else if (command.equals(Actions.myarticles.name())) {
                new UserArticleMenu().execute();
            }

            else if (command.equals(Actions.profile.name())) {
                new ProfileMenu().execute();
            }

            else if (command.equals(Actions.logout.name())) {
                LogoutUseCase logoutUseCase = new LogoutUseCaseImpl();
                logoutUseCase.logout();
                if (AuthenticationService.getInstance().getLoginUser() == null)
                    System.out.println("\t\u2714 Logout successful.\n");
                else
                    System.out.println("\t\u274c Logout failed!\n");
            }
        }
    }
}
