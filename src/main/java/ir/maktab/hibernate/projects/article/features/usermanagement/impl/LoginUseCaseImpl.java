package ir.maktab.hibernate.projects.article.features.usermanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.LoginUseCase;
import org.hibernate.Session;

import java.util.List;

public class LoginUseCaseImpl implements LoginUseCase {
    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty()) {
            System.out.println("\t\u274c Login failed! Username Error\n");
            return null;
        }
        if (password == null || password.isEmpty()) {
            System.out.println("\t\u274c Login failed! Password Error.\n");
            return null;
        }

        Session session = HibernateUtil.getSession();

        List<User> users = session.createQuery("from User").list();
        for (User user : users)
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                AuthenticationService.getInstance().setLoginUser(user);
                System.out.println("\t\u2714 Login successful.\n");
                return user;
            }

        System.out.println("\t\u274c Login failed!\n");
        return null;
    }
}
