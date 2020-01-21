package ir.maktab.hibernate.projects.article.features.usermanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.IsUniqueUsernameUseCase;
import org.hibernate.Session;

import java.util.List;

public class IsUniqueUsernameUseCaseImpl implements IsUniqueUsernameUseCase {
    @Override
    public Boolean test(String username) {
        if (username == null || username.isEmpty()) {
            System.out.println("\t\u274c Failed to Check Username! Username Error.\n");
            return null;
        }

        Session session = HibernateUtil.getSession();

        List<User> users = session.createQuery("from User").list();
        for (User user : users)
            if (user.getUsername().equals(username))
                return false;
        return true;
    }
}
