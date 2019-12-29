package ir.maktab.hibernate.projects.article.core.display;

import ir.maktab.hibernate.projects.article.entities.User;

import java.text.SimpleDateFormat;

public class DisplayUser {
    public static void display(User user){

        if (user == null) return;

        System.out.println(
                ""
                        + "------------------------------------------------------------------------------------"
                        + "\n    ID= " + user.getId()
                        + "\n    Username= '" + user.getUsername()
                        + "'\n    National Code= '"+ user.getNationalCode()
                        + "'\n    Birth Day= '" + new SimpleDateFormat("dd-MM-yyyy").format(user.getBirthDay())
                        + "'\n------------------------------------------------------------------------------------");
    }
}
