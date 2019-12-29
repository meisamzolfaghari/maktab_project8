package ir.maktab.hibernate.projects.article.features.articlemanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.Article;

import java.util.List;

public interface FindUserArticlesByUserUseCase {
    List<Article> list();
}
