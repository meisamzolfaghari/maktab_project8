package ir.maktab.hibernate.projects.article.features.usermanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.RegisterUseCase;
import org.hibernate.Session;

public class RegisterUseCaseImpl implements RegisterUseCase {

    @Override
    public User register(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Integer id = (Integer) session.save(user);
        user = session.load(User.class , id);

        session.close();
        return user;
    }

}
