package ir.maktab.hibernate.projects.article.features.articlemanagement.usecases;

import ir.maktab.hibernate.projects.article.entities.Article;

import java.util.Date;

public interface PublishArticleUseCase {
    Article publish(Article articleForPublish, Date currentDate);
}
