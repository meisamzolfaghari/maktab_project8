package ir.maktab.hibernate.projects.article.core.takefromuser;

import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.impl.IsUniqueUsernameUseCaseImpl;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.IsUniqueUsernameUseCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TakeUserInfoToRegister {
    public static User take(){
        Scanner in = new Scanner(System.in);

        IsUniqueUsernameUseCase isUniqueUsernameUseCase
                = new IsUniqueUsernameUseCaseImpl();

        boolean finished;
        String username;
        String nationalCode;
        String tempBirthDay;
        Date birthDay = null;
        User user = new User();
        do {
            System.out.print("\t\u29bf Username : ");
            username = in.next();
            if (!isUniqueUsernameUseCase.test(username))
                System.out.println("\t\u26a0 Sorry! username is Owned by someone else! try another username...");
            else break;
        } while (true);

        System.out.print("\t\u29bf National Code : ");
        nationalCode = in.next();

        //taking a date and validation...
        do {
            finished = true;
            try {
                System.out.print("\t\u29bf Birth Day (dd-MM-yyyy) : ");
                tempBirthDay = in.next();
                birthDay = new SimpleDateFormat("dd-MM-yyyy").parse(tempBirthDay);
            } catch (ParseException e) {
                finished = false;
                System.out.println("\t\u274c Invalid Date! Try again...\n");
            }
        }while (!finished);

        user.setUsername(username);user.setNationalCode(nationalCode);
        user.setBirthDay(birthDay);user.setPassword(nationalCode);

        return user;
    }
}
