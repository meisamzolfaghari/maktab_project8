package ir.maktab.hibernate.projects.article.features.articlemanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.Article;

import java.util.List;

public interface FindAllArticlesUseCase {
    List<Article> list();
}
