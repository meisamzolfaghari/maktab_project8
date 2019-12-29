package ir.maktab.hibernate.projects.article.core.takefromuser;

import ir.maktab.hibernate.projects.article.core.Actions;
import ir.maktab.hibernate.projects.article.core.display.DisplayMenu;

import java.util.Scanner;

public class TakeCommand {

    public static String takeFirstCommand() {
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("\u231a Please enter command you want to do.");
            DisplayMenu.firstMenu();
            System.out.print("\u29bf Command >> ");
            command = in.nextLine();
            if (!command.equals(Actions.login.name()) && !command.equals(Actions.articles.name())
                    && !command.equals(Actions.register.name()) && !command.equals(Actions.exit.name()))
                System.out.println("\t\u26a0 Invalid Command!");
            else
                return command;
        }
    }

    public static String takeUserCommand() {
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("\u231a Please enter command you want to do.");
            DisplayMenu.userMenu();
            System.out.print("\u29bf Command >> ");
            command = in.nextLine();
            if (!command.equals(Actions.myarticles.name()) && !command.equals(Actions.articles.name())
                    && !command.equals(Actions.profile.name())
                    && !command.equals(Actions.logout.name()) && !command.equals(Actions.exit.name()))
                System.out.println("\t\u26a0 Invalid Command!");
            else
                return command;
        }
    }

    public static String takeArticleCommand() {
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("\u231a Please enter command you want to do.");
            DisplayMenu.articleMenu();
            System.out.print("\u29bf Command >> ");
            command = in.nextLine();
            if (!command.equals(Actions.see.name()) && !command.equals(Actions.back.name())
                    && !command.equals(Actions.exit.name()))
                System.out.println("\t\u26a0 Invalid Command!");
            else
                return command;
        }
    }

    public static String takeUserArticleCommand() {
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("\u231a Please enter command you want to do.");
            DisplayMenu.userArticleMenu();
            System.out.print("\u29bf Command >> ");
            command = in.nextLine();
            if (!command.equals(Actions.see.name()) && !command.equals(Actions.edit.name())
                    && !command.equals(Actions.add.name())
                    && !command.equals(Actions.back.name()) && !command.equals(Actions.exit.name()))
                System.out.println("\t\u26a0 Invalid Command!");
            else
                return command;
        }
    }

    public static String takeProfileCommand() {
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("\u231a Please enter command you want to do.");
            DisplayMenu.profileMenu();
            System.out.print("\u29bf Command >> ");
            command = in.nextLine();
            if (!command.equals(Actions.see.name()) && !command.equals(Actions.edit.name())
                    && !command.equals(Actions.back.name()) && !command.equals(Actions.exit.name()))
                System.out.println("\t\u26a0 Invalid Command!");
            else
                return command;
        }
    }

    public static String takeCategoryCommand() {
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("\u231a Please enter command you want to do.");
            DisplayMenu.categoryMenu();
            System.out.print("\u29bf Command >> ");
            command = in.nextLine();
            if (!command.equals(Actions.choose.name()) && !command.equals(Actions.add.name()))
                System.out.println("\t\u26a0 Invalid Command!");
            else
                return command;
        }
    }

    public static String takeEditArticleCommand() {
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("\u231a Please enter command you want to do.");
            DisplayMenu.editArticleMenu();
            System.out.print("\u29bf Command >> ");
            command = in.nextLine();
            if (!command.equals(Actions.publish.name()) && !command.equals(Actions.unpublish.name())
                    && !command.equals(Actions.title.name()) && !command.equals(Actions.brief.name())
                    && !command.equals(Actions.content.name()) && !command.equals(Actions.back.name())
                    && !command.equals(Actions.exit.name()))
                System.out.println("\t\u26a0 Invalid Command!");
            else
                return command;
        }
    }

    public static String takeEditProfileCommand() {
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("\u231a Please enter command you want to do.");
            DisplayMenu.editProfileMenu();
            System.out.print("\u29bf Command >> ");
            command = in.nextLine();
            if (!command.equals(Actions.username.name()) && !command.equals(Actions.nationcode.name())
                    && !command.equals(Actions.birhday.name()) && !command.equals(Actions.password.name())
                    && !command.equals(Actions.back.name()) && !command.equals(Actions.exit.name()))
                System.out.println("\t\u26a0 Invalid Command!");
            else
                return command;
        }
    }

    public static String takeFinalCommand() {
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("\u231a Please enter command you want to do.");
            DisplayMenu.finalMenu();
            System.out.print("\u29bf Command >> ");
            command = in.nextLine();
            if (!command.equals(Actions.back.name()) && !command.equals(Actions.exit.name()))
                System.out.println("\t\u26a0 Invalid Command!");
            else
                return command;
        }
    }

}
