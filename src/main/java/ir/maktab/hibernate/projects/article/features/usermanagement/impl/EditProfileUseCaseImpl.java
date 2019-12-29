package ir.maktab.hibernate.projects.article.features.usermanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.EditProfileUseCase;
import org.hibernate.Session;

public class EditProfileUseCaseImpl implements EditProfileUseCase {
    @Override
    public User edit(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        if (user == null) return null;

        session.update(user);
        user = session.load(User.class , user.getId());

        session.close();

        return user;
    }
}
