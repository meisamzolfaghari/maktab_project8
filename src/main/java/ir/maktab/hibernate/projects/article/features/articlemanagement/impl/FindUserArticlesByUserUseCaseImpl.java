package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.FindUserArticlesByUserUseCase;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class FindUserArticlesByUserUseCaseImpl implements FindUserArticlesByUserUseCase {
    @Override
    public List<Article> list() {

        List<Article> articles;
        User loginUser = AuthenticationService.getInstance().getLoginUser();
        if (loginUser == null) return null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        articles = session.load(User.class , loginUser.getId()).getArticles();

        session.close();

        return articles;
    }
}
