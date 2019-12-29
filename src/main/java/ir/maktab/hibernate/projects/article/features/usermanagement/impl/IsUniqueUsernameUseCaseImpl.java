package ir.maktab.hibernate.projects.article.features.usermanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.IsUniqueUsernameUseCase;
import org.hibernate.Session;

import java.util.List;

public class IsUniqueUsernameUseCaseImpl implements IsUniqueUsernameUseCase {
    @Override
    public Boolean test(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<User> dbUsers = session.createQuery("from User ").list();
        if (dbUsers.stream().anyMatch(dbUser -> dbUser.getUsername().equals(username))){
            session.close();
            return false;
        }

        session.close();
        return true;
    }
}
