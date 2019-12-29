package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.FindAllArticlesUseCase;
import org.hibernate.Session;

import java.util.List;

public class FindAllArticlesUseCaseImp implements FindAllArticlesUseCase {
    @Override
    public List<Article> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Article> articles = session.createQuery("from Article").list();

        session.close();
        return articles;
    }
}
