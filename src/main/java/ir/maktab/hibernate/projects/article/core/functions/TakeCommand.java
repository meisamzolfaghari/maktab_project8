package ir.maktab.hibernate.projects.article.core.functions;

import ir.maktab.hibernate.projects.article.core.Actions;

import java.util.Scanner;

public class TakeCommand {

    public static String takeFirstCommand() {
        Scanner in = new Scanner(System.in);
        String command = "";
        while (true) {
            System.out.println("\u231a Please enter command you want to do.");
            Display.firstMenu();
            System.out.print("\u29bf Command >> ");
            command = in.nextLine();
            if (!command.equals(Actions.login.name()) && !command.equals(Actions.articles.name())
                    && !command.equals(Actions.exit.name()))
                System.out.println("\t\u26a0 Invalid Command!");
            else
                return command;
        }
    }

    public static String takeUserCommand() {
        Scanner in = new Scanner(System.in);
        String command = "";
        while (true) {
            System.out.println("\u231a Please enter command you want to do.");
            Display.userMenu();
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
        String command = "";
        while (true) {
            System.out.println("\u231a Please enter command you want to do.");
            Display.articleMenu();
            System.out.print("\u29bf Command >> ");
            command = in.nextLine();
            if (!command.equals(Actions.see.name()) && !command.equals(Actions.edit.name())
                    && !command.equals(Actions.add.name())
                    && !command.equals(Actions.logout.name()) && !command.equals(Actions.exit.name()))
                System.out.println("\t\u26a0 Invalid Command!");
            else
                return command;
        }
    }

    public static String takeProfileCommand() {
        Scanner in = new Scanner(System.in);
        String command = "";
        while (true) {
            System.out.println("\u231a Please enter command you want to do.");
            Display.profileMenu();
            System.out.print("\u29bf Command >> ");
            command = in.nextLine();
            if (!command.equals(Actions.see.name()) && !command.equals(Actions.edit.name())
                    && !command.equals(Actions.logout.name()) && !command.equals(Actions.exit.name()))
                System.out.println("\t\u26a0 Invalid Command!");
            else
                return command;
        }
    }

    public static String takeCategoryCommand() {
        Scanner in = new Scanner(System.in);
        String command = "";
        while (true) {
            System.out.println("\u231a Please enter command you want to do.");
            Display.categoryMenu();
            System.out.print("\u29bf Command >> ");
            command = in.nextLine();
            if (!command.equals(Actions.choose.name()) && !command.equals(Actions.add.name())
                    && !command.equals(Actions.logout.name()) && !command.equals(Actions.exit.name()))
                System.out.println("\t\u26a0 Invalid Command!");
            else
                return command;
        }
    }

}
