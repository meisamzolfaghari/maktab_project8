package ir.maktab.hibernate.projects.article.userinterface.functions;

import ir.maktab.hibernate.projects.article.entities.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Users {
    private static Scanner in = new Scanner(System.in);

    public static void display(User user) {

        if (user == null) return;

        System.out.println(
                ""
                        + "------------------------------------------------------------------------------------"
                        + "\n    ID= " + user.getId()
                        + "\n    Username= '" + user.getUsername()
                        + "'\n    National Code= '" + user.getNationalCode()
                        + "'\n    Birth Day= '" + new SimpleDateFormat("dd-MM-yyyy").format(user.getBirthDay())
                        + "'\n------------------------------------------------------------------------------------");
    }


    public static String takeCommand(List<String> actions) {
        String command;
        while (true) {

            System.out.print("\u29bf Command >> ");
            command = in.next();

            if (!actions.contains(command))
                System.out.println("\t\u26a0 Invalid Command!");
            else
                break;
        }
        return command;
    }

    public static String takeUsername() {
        System.out.print("\t\u29bf Username: ");
        return in.next();
    }

    public static String takePassword() {
        System.out.print("\t\u29bf Password: ");
        return in.next();
    }

    public static Date takeBirthday() {
        Date Birthday;
        try {
            System.out.print("\t\u29bf Birth Day (dd-MM-yyyy) : ");
            Birthday = new SimpleDateFormat("dd-MM-yyyy").parse(in.next());
        } catch (ParseException e) {
            System.out.println("\t\u274c Invalid Date!\n");
            return null;
        }

        return Birthday;
    }

    public static String takeNationalCode() {
        System.out.print("\t\u29bf NationalCode: ");
        return in.next();
    }

    public static String takeNewUsername() {
        System.out.print("\t\u29bf New Username >>> ");
        return in.next();
    }

    public static String takeNewPassword() {
        System.out.print("\t\u29bf New Password >>> ");
        String newPassword = in.next();
        System.out.print("\t\u29bf Confirm New Password >>> ");
        if (in.next().equals(newPassword))
            return newPassword;
        else
            System.out.println("\t\u274c Passwords are not match!\n");
        return null;
    }

    public static Date takeNewBirthday() {
        Date newBirthday;
        try {
            System.out.print("\t\u29bf New Birth Day (dd-MM-yyyy) : ");
            newBirthday = new SimpleDateFormat("dd-MM-yyyy").parse(in.next());
        } catch (ParseException e) {
            System.out.println("\t\u274c Invalid Date!\n");
            return null;
        }

        return newBirthday;
    }

    public static String takeNewNationalCode() {
        System.out.print("\t\u29bf New NationalCode >>> ");
        return in.next();
    }
}

