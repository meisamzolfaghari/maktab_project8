package ir.maktab.hibernate.projects.article.features.articlemanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.Article;

public interface DeleteArticleUseCase {
    Boolean delete(Article articleForDelete);
}
