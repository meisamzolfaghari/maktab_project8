package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.ChangeArticleTitleUseCase;
import org.hibernate.Session;

import java.util.Date;

public class ChangeArticleTitleUseCaseImpl implements ChangeArticleTitleUseCase {
    @Override
    public Article change(Article articleForEdit , String newTitle , Date currentDate) {

        if (articleForEdit == null) {
            System.out.println("\t\u274c Failed to Edit Articles Brief! Article Error.\n");
            return null;
        }
        if (newTitle == null || newTitle.isEmpty()) {
            System.out.println("\t\u274c Failed to Edit Articles Brief! New Title Error.\n");
            return null;
        }
        if (currentDate == null) {
            System.out.println("\t\u274c Failed to Edit Articles Brief! Current Date Error.\n");
            return null;
        }

        articleForEdit.setTitle(newTitle);
        articleForEdit.setLastUpdateDate(currentDate);

        Session session = HibernateUtil.getSession();

        session.update(articleForEdit);

        Article editedArticle = session.load(Article.class , articleForEdit.getId());

        if (editedArticle.getTitle().equals(articleForEdit.getTitle())
                && editedArticle.getLastUpdateDate().equals(currentDate))
            System.out.println("\t\u2714 Article's Title successfully Edited.\n");
        else
            System.out.println("\t\u274c Failed to Edit Articles Title!\n");

        return editedArticle;
    }
}
