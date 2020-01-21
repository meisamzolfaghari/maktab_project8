package ir.maktab.hibernate.projects.article.features.articlemanagement.impl;

import ir.maktab.hibernate.projects.article.core.hibernate.HibernateUtil;
import ir.maktab.hibernate.projects.article.entities.Article;
import ir.maktab.hibernate.projects.article.features.articlemanagement.usecases.ChangeArticleBriefUseCase;
import org.hibernate.Session;

import java.util.Date;

public class ChangeArticleBriefUseCaseImpl implements ChangeArticleBriefUseCase {
    @Override
    public Article change(Article articleForEdit, String newBrief , Date currentDate) {

        if (articleForEdit == null) {
            System.out.println("\t\u274c Failed to Edit Articles Brief! Article Error.\n");
            return null;
        }
        if (newBrief == null || newBrief.isEmpty()) {
            System.out.println("\t\u274c Failed to Edit Articles Brief! New Brief Error.\n");
            return null;
        }
        if (currentDate == null) {
            System.out.println("\t\u274c Failed to Edit Articles Brief! Current Date Error.\n");
            return null;
        }

        articleForEdit.setBrief(newBrief);
        articleForEdit.setLastUpdateDate(currentDate);

        Session session = HibernateUtil.getSession();

        session.update(articleForEdit);

        Article editedArticle = session.load(Article.class , articleForEdit.getId());

        if (editedArticle.getBrief().equals(articleForEdit.getBrief())
                && editedArticle.getLastUpdateDate().equals(currentDate))
            System.out.println("\t\u2714 Article's Brief successfully Edited.\n");
        else
            System.out.println("\t\u274c Failed to Edit Articles Brief!\n");

        return editedArticle;
    }
}
