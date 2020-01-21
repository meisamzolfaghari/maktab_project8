package ir.maktab.hibernate.projects.article.features.articlemanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.Article;

import java.util.Date;

public interface ChangeArticleTitleUseCase {
    Article change(Article articleForEdit, String newTitle, Date currentDate);
}
