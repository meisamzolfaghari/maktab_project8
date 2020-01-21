package ir.maktab.hibernate.projects.article.features.articlemanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.Article;

import java.util.Date;

public interface ChangeArticleContentUseCase {
    Article change(Article articleForEdit, String newContent, Date currentDate);
}
