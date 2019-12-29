package ir.maktab.hibernate.projects.article.features.usermanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.LoginUseCase;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LoginUseCaseImpl implements LoginUseCase {

    @Override
    public void login(User user) {

        AuthenticationService.getInstance().setLoginUser(null);

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from User as u where u.username =: username and u.password =: password");
        query.setParameter("username" , user.getUsername());
        query.setParameter("password" , user.getPassword());
        user = (User) query.list().get(0);

        session.close();
        AuthenticationService.getInstance().setLoginUser(user);
    }

}
