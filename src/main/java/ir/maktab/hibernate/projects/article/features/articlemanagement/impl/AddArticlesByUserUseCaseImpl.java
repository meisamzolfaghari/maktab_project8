package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.core.share.AuthenticationService;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.AddArticleByUserUseCase;
import org.hibernate.Session;

public class AddArticlesByUserUseCaseImpl implements AddArticleByUserUseCase {

    @Override
    public Article add(Article article) {

        if (AuthenticationService.getInstance().getLoginUser() == null) return null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        Integer id = (Integer) session.save(article);
        article = session.load(Article.class , id);

        session.close();

        return article;
    }
}
