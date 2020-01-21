package ir.maktab.hibernate.projects.article.features.articlemanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.entities.Category;
import ir.maktab.hibernate.projects.article.entities.User;

import java.util.Date;

public interface AddArticleByUserUseCase {
    Article add(String title, String brief, String Content, Date currentDate, User user, Category category);
}
