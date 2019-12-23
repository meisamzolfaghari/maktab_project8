package ir.maktab.hibernate.projects.article.features.usermanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.usermanagement.usecases.LoginUseCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class LoginUseCaseImpl implements LoginUseCase {

    @Override
    public void login(String username, String password) {
        User user = null;
        AuthenticationService.getInstance().setLoginUser(null);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User as u where u.username >:username and u.password >:password");
        query.setParameter("username" , username);
        query.setParameter("password" , password);
        user = (User) query.uniqueResult();
        session.close();
        AuthenticationService.getInstance().setLoginUser(user);
    }

}
