package ir.maktab.hibernate.projects.article.features.usermanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.ChangeNationalCodeUseCase;
import org.hibernate.Session;

public class ChangeNationalCodeUseCaseImpl implements ChangeNationalCodeUseCase {
    @Override
    public User change(User user , String newNationalCode) {
        if (newNationalCode == null || newNationalCode.isEmpty()) {
            System.out.println("\t\u274c Failed to Edit National Code! New National Code Error.\n");
            return null;
        }
        if (user == null) {
            System.out.println("\t\u274c Failed to Edit National Code! No User Logged In Error.\n");
            return null;
        }

        user.setNationalCode(newNationalCode);

        Session session = HibernateUtil.getSession();

        session.update(user);
        User editedUser = session.load(User.class , user.getId());

        if (editedUser.getNationalCode().equals(newNationalCode)) {
            AuthenticationService.getInstance().setLoginUser(editedUser);
            System.out.println("\t\u2714 National Code successfully Edited.\n");
        } else
            System.out.println("\t\u274c Failed to Edit National Code!\n");
        return editedUser;
    }
}
