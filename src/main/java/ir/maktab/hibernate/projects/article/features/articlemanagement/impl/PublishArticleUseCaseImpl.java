package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.PublishArticleUseCase;
import org.hibernate.Session;

import java.util.Date;

public class PublishArticleUseCaseImpl implements PublishArticleUseCase {
    @Override
    public Article publish(Article articleForPublish, Date currentDate) {
        if (articleForPublish == null){
            System.out.println("\t\u274c Failed to Publish Article Brief! Article Error.\n");
            return null;
        }
        if (currentDate == null) {
            System.out.println("\t\u274c Failed to Publish Article Brief! Current Date Error.\n");
            return null;
        }

        if (articleForPublish.isPublished()) {
            System.out.println("\t\u274c publish failed! you have Already published this Article.\n");
            return null;
        }

        Article publishedArticle;

        articleForPublish.setPublished(true);
        articleForPublish.setPublishDate(currentDate);

        Session session = HibernateUtil.getSession();

        session.update(articleForPublish);
        publishedArticle = session.load(Article.class , articleForPublish.getId());

        if (publishedArticle.isPublished() && publishedArticle.getPublishDate().equals(currentDate))
            System.out.println("\t\u2714 Article successfully published.\n");
        else
            System.out.println("\t\u274c publish failed!\n");

        return publishedArticle;
    }
}
