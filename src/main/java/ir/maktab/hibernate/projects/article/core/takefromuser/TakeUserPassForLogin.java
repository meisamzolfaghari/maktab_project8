package ir.maktab.hibernate.projects.article.core.takefromuser;

import ir.maktab.hibernate.projects.article.entities.User;

import java.util.Scanner;

public class TakeUserPassForLogin {

    public static User take(){
        Scanner in = new Scanner(System.in);
        User user = new User();
        System.out.print("\t\u29bf Username : ");
        user.setUsername(in.next());

        //taking password from user
        System.out.print("\t\u29bf Password : ");
        user.setPassword(in.next());

        return user;
    }

}
