package ir.maktab.hibernate.projects.article.core.menus;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.impl.EditProfileUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.usermanagement.impl.IsUniqueUsernameUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.EditProfileUseCase;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.IsUniqueUsernameUseCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class EditProfileMenu extends Menu {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);

        command = "";

        while (!command.equals(Actions.back.name())) {

            takeCommand();

            if (command.equals(Actions.exit.name())) {
                System.out.println("\n bye bye!");
                System.exit(0);
            }

            else if (command.equals(Actions.back.name())) continue;

            EditProfileUseCase editProfileUseCase
                    = new EditProfileUseCaseImpl();

            User editedLoginUser;

            User loginUser = AuthenticationService.getInstance().getLoginUser();

            if (command.equals(Actions.username.name())) {
                IsUniqueUsernameUseCase isUniqueUsernameUseCase
                        = new IsUniqueUsernameUseCaseImpl();

                System.out.print("\t\u29bf Last Username : " + loginUser.getUsername());
                String username;
                do {
                    System.out.print("\t\u29bf New Username >>> ");
                    username = in.next();
                    if (!isUniqueUsernameUseCase.test(username))
                        System.out.println("\t\u26a0 Sorry! username is Owned by someone else! try another username...");
                    else break;
                } while (true);

                loginUser.setUsername(username);

                editedLoginUser = editProfileUseCase.edit(loginUser);

                if (editedLoginUser.getUsername().equals(loginUser.getUsername())) {
                    AuthenticationService.getInstance().setLoginUser(editedLoginUser);
                    System.out.println("\t\u2714 Username successfully Edited.\n");
                } else
                    System.out.println("\t\u274c Failed to Edit Username!\n");

            } else if (command.equals(Actions.nationcode.name())) {
                String nationalCode;
                System.out.print("\t\u29bf Last National Code : " + loginUser.getNationalCode());
                System.out.print("\t\u29bf New National Code >>> ");
                nationalCode = in.next();

                loginUser.setNationalCode(nationalCode);

                editedLoginUser = editProfileUseCase.edit(loginUser);

                if (editedLoginUser.getNationalCode().equals(loginUser.getNationalCode())) {
                    AuthenticationService.getInstance().setLoginUser(editedLoginUser);
                    System.out.println("\t\u2714 National Code successfully Edited.\n");
                } else
                    System.out.println("\t\u274c Failed to Edit National Code!\n");
            } else if (command.equals(Actions.birhday.name())) {
                System.out.print("\t\u29bf Last Birth Day : "
                        + new SimpleDateFormat("dd-MM-yyyy").format(loginUser.getBirthDay()));
                boolean finished;
                Date birthDay = null;
                do {
                    finished = true;
                    try {
                        System.out.print("\t\u29bf New Birth Day (dd-MM-yyyy) : ");
                        birthDay = new SimpleDateFormat("dd-MM-yyyy").parse(in.next());
                    } catch (ParseException e) {
                        finished = false;
                        System.out.println("\t\u274c Invalid Date! Try again...\n");
                    }
                } while (!finished);

                loginUser.setBirthDay(birthDay);

                editedLoginUser = editProfileUseCase.edit(loginUser);

                if (editedLoginUser.getBirthDay().equals(loginUser.getBirthDay())) {
                    AuthenticationService.getInstance().setLoginUser(editedLoginUser);
                    System.out.println("\t\u2714 Birth Day successfully Edited.\n");
                } else
                    System.out.println("\t\u274c Failed to Edit Birth Day!\n");
            } else if (command.equals(Actions.password.name())) {
                String password;
                while (true) {
                    System.out.print("\t\u29bf New Password >>> ");
                    password = in.next();
                    System.out.println("\t\u29bf Confirm New Password >>> ");
                    if (in.next().equals(password)) {
                        loginUser.setPassword(password);

                        editedLoginUser = editProfileUseCase.edit(loginUser);

                        if (editedLoginUser.getPassword().equals(loginUser.getPassword())) {
                            AuthenticationService.getInstance().setLoginUser(editedLoginUser);
                            System.out.println("\t\u2714 Password successfully Changed.\n");
                        } else
                            System.out.println("\t\u274c Failed to Change Password!\n");
                        break;
                    } else
                        System.out.println("\t\u274c Passwords are not match! Try again....\n");
                }
            }
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
