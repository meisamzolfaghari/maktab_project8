package ir.maktab.hibernate.projects.article.features.usermanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.ChangeUsernameUseCase;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.IsUniqueUsernameUseCase;
import org.hibernate.Session;

public class ChangeUsernameUseCaseImpl implements ChangeUsernameUseCase {
    @Override
    public User change(User user , String newUsername) {
        if (newUsername == null || newUsername.isEmpty()) {
            System.out.println("\t\u274c Failed to Edit Username! New Username Error.\n");
            return null;
        }
        if (user == null) {
            System.out.println("\t\u274c Failed to Edit Username! No User Logged In Error.\n");
            return null;
        }

        IsUniqueUsernameUseCase isUniqueUsernameUseCase
                = new IsUniqueUsernameUseCaseImpl();

        if (!isUniqueUsernameUseCase.test(newUsername)) {
            System.out.println("\t\u26a0 Sorry! username is Owned by someone else! try another username...");
            return null;
        }

        user.setUsername(newUsername);

        Session session = HibernateUtil.getSession();

        session.update(user);
        User editedUser = session.load(User.class , user.getId());

        if (editedUser.getUsername().equals(newUsername)) {
            AuthenticationService.getInstance().setLoginUser(editedUser);
            System.out.println("\t\u2714 Username successfully Edited.\n");
        } else
            System.out.println("\t\u274c Failed to Edit Username!\n");

        return editedUser;
    }
}
