package ir.maktab.hibernate.projects.article.features.usermanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.ChangePasswordUseCase;
import org.hibernate.Session;

public class ChangePasswordUseCaseImpl implements ChangePasswordUseCase {
    @Override
    public User change(User user , String newPassword) {
        if (newPassword == null || newPassword.isEmpty()) {
            System.out.println("\t\u274c Failed to Change Password! New Password Error.\n");
            return null;
        }
        User loginUser = AuthenticationService.getInstance().getLoginUser();
        if (loginUser == null) {
            System.out.println("\t\u274c Failed to Change Password! No User Logged In Error.\n");
            return null;
        }

        loginUser.setPassword(newPassword);

        Session session = HibernateUtil.getSession();

        session.update(user);
        User editedUser = session.load(User.class , user.getId());


        if (editedUser.getPassword().equals(newPassword)) {
            AuthenticationService.getInstance().setLoginUser(editedUser);
            System.out.println("\t\u2714 Password successfully Changed.\n");
        } else
            System.out.println("\t\u274c Failed to Change Password!\n");
        return editedUser;
    }
}
