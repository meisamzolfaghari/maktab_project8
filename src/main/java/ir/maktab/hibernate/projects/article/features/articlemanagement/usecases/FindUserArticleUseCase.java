package ir.maktab.hibernate.projects.article.features.articlemanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.entities.User;

import java.util.List;

public interface FindUserArticleUseCase {
    List<Article> findAll(User user);
}
