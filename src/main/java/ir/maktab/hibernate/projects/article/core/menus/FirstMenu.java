package ir.maktab.hibernate.projects.article.core.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.takefromuser.TakeUserInfoToRegister;
import ir.maktab.hibernate.projects.article.core.takefromuser.TakeUserPassForLogin;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.core.takefromuser.TakeCommand;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.impl.LoginUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.usermanagement.impl.RegisterUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.LoginUseCase;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.RegisterUseCase;

public class FirstMenu implements Menu {

    @Override
    public void execute() {
        String command ;

        while (true) {

            command = TakeCommand.takeFirstCommand();

            if (command.equals(Actions.exit.name())) {
                System.out.println("\n bye bye!");
                System.exit(0);
            }

            else if (command.equals(Actions.articles.name())) {
                new ArticleMenu().execute();
            }

            else if (command.equals(Actions.login.name())) {
                LoginUseCase loginUseCase
                        = new LoginUseCaseImpl();

                loginUseCase.login(TakeUserPassForLogin.take());

                User loginUser = AuthenticationService.getInstance().getLoginUser();

                if (loginUser != null) {
                    System.out.println("\t\u2714 Login successful.\n");

                    new UserMenu().execute();
                }

                else
                    System.out.println("\t\u274c Login failed!\n");
            }

            else if (command.equals(Actions.register.name())) {
                RegisterUseCase registerUseCase
                        = new RegisterUseCaseImpl();

                User userToRegister = TakeUserInfoToRegister.take();

                User registeredUser = registerUseCase.register(userToRegister);

                if (registeredUser != null)
                    System.out.println("\t\u2714 User successfully Registered.\n");
                else
                    System.out.println("\t\u274c Register Failed!\n");
            }
        }
    }
}
