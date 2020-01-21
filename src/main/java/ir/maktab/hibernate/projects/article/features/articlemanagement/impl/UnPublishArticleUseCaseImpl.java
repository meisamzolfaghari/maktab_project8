package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.UnPublishArticleUseCase;
import org.hibernate.Session;

import java.util.Date;

public class UnPublishArticleUseCaseImpl implements UnPublishArticleUseCase {
    @Override
    public Article unPublish(Article articleForUnPublish, Date currentDate) {
        if (articleForUnPublish == null) {
            System.out.println("\t\u274c Failed to UnPublish Article Brief! Article Error.\n");
            return null;
        }
        if (currentDate == null) {
            System.out.println("\t\u274c Failed to UnPublish Article Brief! Current Date Error.\n");
            return null;
        }

        if (!articleForUnPublish.isPublished()) {
            System.out.println("\t\u274c UnPublish failed! This Article is Already Unpublished.\n");
            return null;
        }

        Article unpublishedArticle;

        articleForUnPublish.setPublished(false);
        articleForUnPublish.setPublishDate(null);

        Session session = HibernateUtil.getSession();

        session.update(articleForUnPublish);
        unpublishedArticle = session.load(Article.class , articleForUnPublish.getId());

        if (!unpublishedArticle.isPublished() && unpublishedArticle.getPublishDate() == null)
            System.out.println("\t\u2714 Article successfully Unpublished.\n");
        else
            System.out.println("\t\u274c UnPublish failed!\n");

        return unpublishedArticle;
    }
}
