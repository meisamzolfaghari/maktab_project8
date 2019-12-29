package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.EditArticleByUserUseCase;
import org.hibernate.Session;

public class EditArticleByUserUseCaseImpl implements EditArticleByUserUseCase {
    @Override
    public Article edit(Article article) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        if (article == null) return null;

        session.update(article);
        article = session.load(Article.class , article.getId());

        session.close();

        return article;
    }
}
