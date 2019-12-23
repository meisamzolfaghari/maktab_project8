package ir.maktab.hibernate.projects.article.features.usermanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.RegisterUseCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class RegisterUseCaseImpl implements RegisterUseCase {

    @Override
    public Integer register(String username, String nationalCode, Date birthDay, String password) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Integer id = (Integer) session.save(new User(null , username , nationalCode , birthDay , password));
        session.close();
        return id;
    }
}
