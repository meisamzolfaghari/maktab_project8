package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.FindAllPublishedArticleUseCase;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllPublishedArticleUseCaseImpl implements FindAllPublishedArticleUseCase {
    @Override
    public List<Article> list() {
        List<Article> articles = HibernateUtil.getSession()
                .createQuery("from Article ").list();
        return articles
                .stream()
                .filter(Article::isPublished)
                .collect(Collectors.toList());
    }
}
