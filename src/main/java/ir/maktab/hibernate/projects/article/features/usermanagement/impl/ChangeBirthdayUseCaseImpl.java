package ir.maktab.hibernate.projects.article.features.usermanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.ChangeBirthdayUseCase;
import org.hibernate.Session;

import java.util.Date;

public class ChangeBirthdayUseCaseImpl implements ChangeBirthdayUseCase {
    @Override
    public User change(User user , Date newBirthday) {
        if (newBirthday == null) {
            System.out.println("\t\u274c Failed to Edit Birth Day! New Birthday Error.\n");
            return null;
        }
        if (user == null) {
            System.out.println("\t\u274c Failed to Edit Birth Day! No User Logged in Error.\n");
            return null;
        }

        user.setBirthDay(newBirthday);

        Session session = HibernateUtil.getSession();

        session.update(user);
        User editedUser = session.load(User.class , user.getId());

        if (editedUser.getBirthDay().equals(newBirthday)) {
            AuthenticationService.getInstance().setLoginUser(editedUser);
            System.out.println("\t\u2714 Birth Day successfully Edited.\n");
        } else
            System.out.println("\t\u274c Failed to Edit Birth Day!\n");

        return editedUser;
    }
}
