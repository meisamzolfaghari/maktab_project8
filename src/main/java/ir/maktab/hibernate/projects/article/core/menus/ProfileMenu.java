package ir.maktab.hibernate.projects.article.core.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.display.DisplayUser;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.core.takefromuser.TakeCommand;
import ir.maktab.hibernate.projects.article.entities.User;

public class ProfileMenu implements Menu {

    @Override
    public void execute() {

        String command = "";

        while (!command.equals(Actions.back.name())) {
            User loginUser = AuthenticationService.getInstance().getLoginUser();

            DisplayUser.display(loginUser);

            command = TakeCommand.takeProfileCommand();

            if (command.equals(Actions.exit.name())) {
                System.out.println("\n bye bye!");
                System.exit(0);
            }

            else if (command.equals(Actions.edit.name())) {
                new EditProfileMenu().execute();
            }
        }
    }
}
