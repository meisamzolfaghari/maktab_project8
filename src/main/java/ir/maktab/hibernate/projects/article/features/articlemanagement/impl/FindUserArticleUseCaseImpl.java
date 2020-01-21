package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.entities.User;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.FindUserArticleUseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindUserArticleUseCaseImpl implements FindUserArticleUseCase {
    @Override
    public List<Article> findAll(User user) {
        if (user == null){
            System.out.println("\t\u274c Failed to Find Articles! User Error.\n");
            return new ArrayList<>();
        }

        List<Article> articles = HibernateUtil.getSession()
                .createQuery("from Article ").list();

        return articles
                .stream()
                .filter(article -> article.getUser().equals(user))
                .collect(Collectors.toList());
    }
}
